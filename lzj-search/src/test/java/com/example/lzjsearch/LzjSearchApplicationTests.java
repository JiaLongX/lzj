package com.example.lzjsearch;

import com.example.lzjpojo.Item;
import com.example.lzjsearch.dao.SearchForESDao;
import com.example.lzjsearch.entity.ItemForES;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
class LzjSearchApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private SearchForESDao searchForESDao;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Value("${fastdfs.storage.nginx.prefix}")
    private String fastdfsStorageNginxPrefix;

    @Test
    void contextLoads() {
        List<Item> items = mongoTemplate.findAll(Item.class);
        List<ItemForES> itemForES = new ArrayList<>();
        for (Item item : items) {
            ItemForES itemForES1 = new ItemForES();
            itemForES1.setId(item.getId());
            itemForES1.setTitle(item.getTitle());
            itemForES1.setCity(item.getCity());
            itemForES1.setHouseType(item.getHouseTypeForSearch());
            itemForES1.setImg(fastdfsStorageNginxPrefix + item.getImg());
            itemForES1.setPrice("<h3>" + item.getPrice() + "</h3>");
            itemForES1.setRentType(item.getRentType());
            itemForES.add(itemForES1);
        }
        searchForESDao.batchSave(itemForES);
    }

    @Test
    public void testSearch() {
        // ????????????
        HighlightBuilder.Field field = new HighlightBuilder.Field("title");
        field.preTags("<span style='color:red'>");
        field.postTags("</span>");

        // ???????????????????????????
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        // ????????????????????????
        List<QueryBuilder> mustList = boolQueryBuilder.must();
        mustList.add(QueryBuilders.matchQuery("city", "??????"));
        // ????????????????????????
        List<QueryBuilder> shouldList = boolQueryBuilder.should();
        shouldList.add(QueryBuilders.matchQuery("title", "??????")); // ????????????
        shouldList.add(QueryBuilders.matchQuery("houseType", "??????")); // ??????????????????
        shouldList.add(QueryBuilders.matchQuery("rentType", "??????")); // ??????????????????

        // ?????????????????????
        NativeSearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(boolQueryBuilder) // ????????????
                .withHighlightFields(field) // ??????
                .withPageable(PageRequest.of(0, 2)) // ??????
                .build();

        // ??????
        SearchHits<ItemForES> search = elasticsearchRestTemplate.search(query, ItemForES.class);

        // ????????????????????????
        List<ItemForES> itemForESList = new ArrayList<>();
        // ??????????????????
        for (SearchHit<ItemForES> searchHit : search) {
            // ??????????????????
            ItemForES itemForES = searchHit.getContent();
            // ??????????????????
            Map<String, List<String>> highlightFields = searchHit.getHighlightFields();
            if (highlightFields.containsKey("title")) {
                String title = highlightFields.get("title").get(0);
                itemForES.setTitle(title);
            }
            itemForESList.add(itemForES);
        }
        System.out.println(itemForESList);

        // ?????????????????????
        long totalHits = search.getTotalHits();
        System.out.println(totalHits);
        // ????????? > (????????? + 1) * ???????????????
        if (totalHits > (0 + 1) * 2) {
            System.out.println(true);
        }
    }

}
