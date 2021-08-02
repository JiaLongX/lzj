package com.example.lzjpojo;

import lombok.*;

import java.io.Serializable;

/**
 * 商品评价实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment implements Serializable {

    private String id;
    // 商品主键，是为哪一个商品做的评价。
    private String itemId;
    // 用户名， 手机号
    private String username;
    // 评价信息
    private String comment;
    // 评分
    private byte star;

}