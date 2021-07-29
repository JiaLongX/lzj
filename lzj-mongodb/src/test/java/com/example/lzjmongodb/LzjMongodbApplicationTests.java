package com.example.lzjmongodb;

import com.example.lzjpojo.Banner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@SpringBootTest
class LzjMongodbApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void insertBanners() {
        List<Banner> list = new ArrayList<>();

        Banner banner1 = new Banner();
        banner1.setCreateTime(new Date());
        banner1.setUrl("group1/M00/00/00/wKgKZGEBDguAP8ztABLGyzFLLI0719.png");

        Banner banner2 = new Banner();
        banner2.setCreateTime(new Date());
        banner2.setUrl("group1/M00/00/00/wKgKZGEBDg-ANAzYAAjIoTDLsvM604.png");

        Banner banner3 = new Banner();
        banner3.setCreateTime(new Date());
        banner3.setUrl("ggroup1/M00/00/00/wKgKZGEBDhKAeJBUAAro9zs5IOg294.png");

        Banner banner4 = new Banner();
        banner4.setCreateTime(new Date());
        banner4.setUrl("group1/M00/00/00/wKgKZGEBDhSAUqyOAAuC4z59RTI405.png");

        Banner banner5 = new Banner();
        banner5.setCreateTime(new Date());
        banner5.setUrl("group1/M00/00/00/wKgKZGEBDhaAa9b6ABS0Li3X3nE295.png");

        Banner banner6 = new Banner();
        banner6.setCreateTime(new Date());
        banner6.setUrl("group1/M00/00/00/wKgKZGEBDhmAb74wABHVEJUid8Y569.png");

        list.add(banner1);
        list.add(banner2);
        list.add(banner3);
        list.add(banner4);
        list.add(banner5);
        list.add(banner6);

        Collection<Banner> result = mongoTemplate.insert(list, Banner.class);
        System.out.println(result);
    }

}
