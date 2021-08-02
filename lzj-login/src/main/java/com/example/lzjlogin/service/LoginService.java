package com.example.lzjlogin.service;

import com.example.lzjcommons.result.LzjResult;

/**
 * 登录服务业务逻辑层
 */
public interface LoginService {

    /**
     * 根据用户名和密码登录
     *
     * @param username 手机号
     * @param password 验证码
     * @return
     */
    LzjResult login(String username, String password);

}