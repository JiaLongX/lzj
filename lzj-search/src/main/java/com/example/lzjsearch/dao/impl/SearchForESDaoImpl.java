package com.example.lzjsearch.dao.impl;

import com.example.lzjsearch.dao.SearchForESDao;
import com.example.lzjsearch.entity.ItemForES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class SearchForESDaoImpl implements SearchForESDao {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Override
    public void batchSave(List<ItemForES> itemList) {
        // 批量新增
        elasticsearchRestTemplate.save(itemList);
    }

    @Override
    public void save(ItemForES item) {
        batchSave(Arrays.asList(item));
    }

    @Override
    public SearchHits<ItemForES> selectItemForPage(NativeSearchQuery query) {
        return elasticsearchRestTemplate.search(query,ItemForES.class);
    }
}