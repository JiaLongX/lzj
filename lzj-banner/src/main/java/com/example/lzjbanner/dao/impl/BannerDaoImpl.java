package com.example.lzjbanner.dao.impl;

import com.example.lzjbanner.dao.BannerDao;
import com.example.lzjpojo.Banner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
@Repository
public class BannerDaoImpl implements BannerDao {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public List<Banner> selectBannerList(Query query) {
        return mongoTemplate.find(query,Banner.class);
    }
}
