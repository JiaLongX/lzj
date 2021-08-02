package com.example.lzjhotproduct.dao;

import com.example.lzjpojo.Item;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public interface HotProductDao {
    List<Item> selectHotProduct(Query query);
}
