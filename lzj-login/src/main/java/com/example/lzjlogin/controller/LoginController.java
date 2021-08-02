package com.example.lzjlogin.controller;

import com.example.lzjcommons.result.LzjResult;
import com.example.lzjlogin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录服务控制层
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    @PostMapping
    LzjResult login(String username, String password) {
        return loginService.login(username, password);
    }

}