package com.example.lzjsearch.dao;

import com.example.lzjsearch.entity.ItemForES;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;

import java.util.List;

public interface SearchForESDao {

    // 批量数据新增到 ES
    void batchSave(List<ItemForES> items);

    // 单数据新增到 ES
    void save(ItemForES item);

    /**
     * 分页、高亮查询
     *
     * @param query
     * @return
     */
    SearchHits<ItemForES> selectItemForPage(NativeSearchQuery query);
}