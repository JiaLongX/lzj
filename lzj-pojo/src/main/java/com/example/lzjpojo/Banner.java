package com.example.lzjpojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Banner implements Serializable {
    // 主键
    private String id;
    // 图片地址
    private String url;
    // 创建时间
    private Date createTime;
}