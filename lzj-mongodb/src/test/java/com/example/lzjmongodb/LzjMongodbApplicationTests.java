package com.example.lzjmongodb;

import com.example.lzjpojo.Banner;
import com.example.lzjpojo.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.*;

@SpringBootTest
@ActiveProfiles("mongodb")
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

    @Test
    public void insertHotProduct() {
        List<Item> items = new ArrayList<>();

        Item item = new Item();
        item.setCity("北京");
        item.setHouseType("150 ㎡");
        item.setImgs(
                Arrays.asList(
                        "group1/M00/00/00/wKgKZGEBxtiAFfxFAADZCwsgDr8419.jpg",
                        "group1/M00/00/00/wKgKZGEBxtyAcvMhAACj6oiIMnY585.jpg",
                        "group1/M00/00/00/wKgKZGEBxt-AR9Z2AADzZuYOH74733.jpg"
                )
        );
        item.setPrice(12000L);
        item.setRecommendation(true);
        item.setRecoSort((byte) 9);
        item.setRentType("整租");
        item.setSales(100L);
        item.setTitle("北京高档公寓");
        Map<String, String> info = new HashMap<>();
        info.put("years", "2010");
        info.put("type", "3室2厅");
        info.put("level", "10/18层");
        info.put("style", "精装修");
        info.put("orientation", "南北通透");
        item.setInfo(info);
        items.add(item);

        item = new Item();
        item.setCity("北京");
        item.setHouseType("230 ㎡");
        item.setImgs(
                Arrays.asList(
                        "group1/M00/00/00/wKgKZGEBxuGAInjbAADEWJ2H-q8092.jpg",
                        "group1/M00/00/00/wKgKZGEBxuSAA7FSAACUlqaDUJs116.jpg",
                        "group1/M00/00/00/wKgKZGEBxueAIY_zAACkIflZOdk145.jpg"
                )
        );
        item.setPrice(21000L);
        item.setRecommendation(true);
        item.setRecoSort((byte) 12);
        item.setRentType("整租");
        item.setSales(30L);
        info = new HashMap<>();
        info.put("years", "2007");
        info.put("type", "5室3厅");
        info.put("level", "2/2层");
        info.put("style", "精装修");
        info.put("orientation", "南北通透");
        item.setInfo(info);
        item.setTitle("北京联排别墅");
        items.add(item);

        item = new Item();
        item.setCity("北京");
        item.setHouseType("310 ㎡");
        item.setImgs(
                Arrays.asList(
                        "group1/M00/00/00/wKgKZGEBxtiAFfxFAADZCwsgDr8419.jpg",
                        "group1/M00/00/00/wKgKZGEBxtyAcvMhAACj6oiIMnY585.jpg",
                        "group1/M00/00/00/wKgKZGEBxt-AR9Z2AADzZuYOH74733.jpg"
                )
        );
        item.setPrice(30000L);
        item.setRecommendation(true);
        item.setRecoSort((byte) 6);
        item.setRentType("整租");
        item.setSales(10L);
        info = new HashMap<>();
        info.put("years", "2013");
        info.put("type", "6室4厅");
        info.put("level", "3/3层");
        info.put("style", "豪华装修");
        info.put("orientation", "四面环海");
        item.setInfo(info);
        item.setTitle("北京独栋别墅");
        items.add(item);

        item = new Item();
        item.setCity("北京");
        item.setHouseType("60 ㎡");
        item.setImgs(
                Arrays.asList(
                        "group1/M00/00/00/wKgKZGEBxuGAInjbAADEWJ2H-q8092.jpg",
                        "group1/M00/00/00/wKgKZGEBxuSAA7FSAACUlqaDUJs116.jpg",
                        "group1/M00/00/00/wKgKZGEBxueAIY_zAACkIflZOdk145.jpg"
                )
        );
        item.setPrice(3000L);
        item.setRecommendation(true);
        item.setRecoSort((byte) 9);
        item.setRentType("整租");
        item.setSales(300L);
        info = new HashMap<>();
        info.put("years", "2000");
        info.put("type", "2室1厅");
        info.put("level", "6/6层");
        info.put("style", "简单装修");
        info.put("orientation", "朝南");
        item.setInfo(info);
        item.setTitle("北京老小区");
        items.add(item);

        item = new Item();
        item.setCity("上海");
        item.setHouseType("150 ㎡");
        item.setImgs(
                Arrays.asList(
                        "group1/M00/00/00/wKgKZGEBxtiAFfxFAADZCwsgDr8419.jpg",
                        "group1/M00/00/00/wKgKZGEBxtyAcvMhAACj6oiIMnY585.jpg",
                        "group1/M00/00/00/wKgKZGEBxt-AR9Z2AADzZuYOH74733.jpg"
                )
        );
        item.setPrice(12000L);
        item.setRecommendation(true);
        item.setRecoSort((byte) 9);
        item.setRentType("整租");
        item.setSales(100L);
        item.setTitle("上海高档公寓");
        info = new HashMap<>();
        info.put("years", "2010");
        info.put("type", "3室2厅");
        info.put("level", "10/18层");
        info.put("style", "精装修");
        info.put("orientation", "南北通透");
        item.setInfo(info);
        items.add(item);

        item = new Item();
        item.setCity("上海");
        item.setHouseType("230 ㎡");
        item.setImgs(
                Arrays.asList(
                        "group1/M00/00/00/wKgKZGEBxuGAInjbAADEWJ2H-q8092.jpg",
                        "group1/M00/00/00/wKgKZGEBxuSAA7FSAACUlqaDUJs116.jpg",
                        "group1/M00/00/00/wKgKZGEBxueAIY_zAACkIflZOdk145.jpg"
                )
        );
        item.setPrice(21000L);
        item.setRecommendation(true);
        item.setRecoSort((byte) 12);
        item.setRentType("整租");
        item.setSales(30L);
        info = new HashMap<>();
        info.put("years", "2007");
        info.put("type", "5室3厅");
        info.put("level", "2/2层");
        info.put("style", "精装修");
        info.put("orientation", "南北通透");
        item.setInfo(info);
        item.setTitle("上海联排别墅");
        items.add(item);

        item = new Item();
        item.setCity("上海");
        item.setHouseType("310 ㎡");
        item.setImgs(
                Arrays.asList(
                        "group1/M00/00/00/wKgKZGEBxtiAFfxFAADZCwsgDr8419.jpg",
                        "group1/M00/00/00/wKgKZGEBxtyAcvMhAACj6oiIMnY585.jpg",
                        "group1/M00/00/00/wKgKZGEBxt-AR9Z2AADzZuYOH74733.jpg"
                )
        );
        item.setPrice(30000L);
        item.setRecommendation(true);
        item.setRecoSort((byte) 6);
        item.setRentType("整租");
        item.setSales(10L);
        info = new HashMap<>();
        info.put("years", "2013");
        info.put("type", "6室4厅");
        info.put("level", "3/3层");
        info.put("style", "豪华装修");
        info.put("orientation", "四面环海");
        item.setInfo(info);
        item.setTitle("上海独栋别墅");
        items.add(item);

        item = new Item();
        item.setCity("上海");
        item.setHouseType("60 ㎡");
        item.setImgs(
                Arrays.asList(
                        "group1/M00/00/00/wKgKZGEBxuGAInjbAADEWJ2H-q8092.jpg",
                        "group1/M00/00/00/wKgKZGEBxuSAA7FSAACUlqaDUJs116.jpg",
                        "group1/M00/00/00/wKgKZGEBxueAIY_zAACkIflZOdk145.jpg"
                )
        );
        item.setPrice(3000L);
        item.setRecommendation(true);
        item.setRecoSort((byte) 9);
        item.setRentType("整租");
        item.setSales(300L);
        info = new HashMap<>();
        info.put("years", "2000");
        info.put("type", "2室1厅");
        info.put("level", "6/6层");
        info.put("style", "简单装修");
        info.put("orientation", "朝南");
        item.setInfo(info);
        item.setTitle("上海老小区");
        items.add(item);

        Collection<Item> result = mongoTemplate.insert(items, Item.class);
        System.out.println(result);
    }

}
