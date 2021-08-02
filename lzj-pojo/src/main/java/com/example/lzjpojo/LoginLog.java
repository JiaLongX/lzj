package com.example.lzjpojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginLog implements Serializable {

    private String id;
    private String username; // 用户名，就是手机号。
    private String type; // 登录方式， 1 - 验证码登录； 2 - 用户名密码登录
    private Date loginTime; // 登录时间
    private Boolean isSuccess; // 是否登录成功， true - 成功； false - 失败
    private String message; // 日志消息， 如：手机号不存在； 验证码错误； 验证码过期等。

}