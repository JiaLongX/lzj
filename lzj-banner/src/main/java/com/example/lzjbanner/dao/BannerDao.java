package com.example.lzjbanner.dao;

import com.example.lzjpojo.Banner;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public interface BannerDao {
    List<Banner> selectBannerList(Query query);
}
