package com.example.lzjsearch.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "lzj-item")
@Data
@NoArgsConstructor
public class ItemForES {

    @Id
    private String id;
    // 租赁方式, 不分词
    @Field(type = FieldType.Keyword)
    private String rentType;
    // 价格， <h3> 价格 </h3> ， 不分词
    @Field(type = FieldType.Keyword)
    private String price;
    // 房屋类型
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String houseType;
    // 图片地址 不分词
    @Field(type = FieldType.Keyword)
    private String img;
    // 商品标题
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title;
    // 城市 不分词
    @Field(type = FieldType.Keyword)
    private String city;

}