package com.example.lzjsearch.service.impl;

import com.example.lzjcommons.result.LzjResult;
import com.example.lzjsearch.dao.SearchForESDao;
import com.example.lzjsearch.entity.ItemForES;
import com.example.lzjsearch.service.SearchForESService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SearchForESServiceImpl implements SearchForESService {

    @Resource
    private SearchForESDao searchForESDao;

    @Override
    public LzjResult selectItemForPage(String city, String content, int page, int size) {
        // 设置高亮 <span style='color:red'></span>
        HighlightBuilder.Field field = new HighlightBuilder.Field("title");
        field.preTags("<span style='color:red'>");
        field.postTags("</span>");

        /**
         * 设置查询条件
         *  1. 必选 city 城市
         *  2. 关键词 content 对应 title 字段
         *  3. 可选 title 标题 houseType 房屋类型 rentType 租赁方式
         */
        // 初始化搜索条件对象
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        // 必选条件集合
        List<QueryBuilder> mustList = boolQueryBuilder.must();
        mustList.add(QueryBuilders.matchQuery("city", city));
        // 可选条件集合
        List<QueryBuilder> shouldList = boolQueryBuilder.should();
        // content
        shouldList.add(QueryBuilders.matchQuery("title", content)); // 标题搜索
        shouldList.add(QueryBuilders.matchQuery("houseType", content)); // 房屋类型搜索
        shouldList.add(QueryBuilders.matchQuery("rentType", content)); // 租赁方式搜索

        // 构建查询对象
        // 设置高亮、分页、查询条件
        // 初始化查询对象
        NativeSearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(boolQueryBuilder) // 搜索条件
                .withHighlightFields(field) // 高亮
                .withPageable(PageRequest.of(page, size)) // 分页
                .build();

        // 查询
        SearchHits<ItemForES> search = searchForESDao.selectItemForPage(query);

        // 处理结果集
        List<ItemForES> itemForESList = new ArrayList<>();
        // 处理查询逻辑
        for (SearchHit<ItemForES> searchHit : search) {
            // 获取结果对象
            ItemForES itemForES = searchHit.getContent();
            // 处理高亮信息
            Map<String, List<String>> highlightFields = searchHit.getHighlightFields();
            // 是否有高亮信息
            if (highlightFields.containsKey("title")) {
                String title = highlightFields.get("title").get(0);
                itemForES.setTitle(title);
            }
            itemForESList.add(itemForES);
        }

        // 构建页面返回对象
        LzjResult result = LzjResult.success("查询成功", itemForESList);
        // 处理是否还有更多内容属性
        // 获取查询总条数
        if (search.getTotalHits() > (page + 1) * size) {
            result.setHasMore(true);
        }
        return result;
    }
}
