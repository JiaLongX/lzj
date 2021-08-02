package com.example.lzjsendyzm.controller;

import com.example.lzjcommons.result.LzjResult;
import com.example.lzjsendyzm.service.SendyzmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 验证码服务控制层
 */
@RestController
@RequestMapping("/sendyzm")
public class SendyzmController {

    @Autowired
    private SendyzmService sendyzmService;

    /**
     * 发送验证码并保存 Redis
     *
     * @return
     */
    @PostMapping
    public LzjResult sendyzm(String phone) {
        return sendyzmService.sendyzm(phone);
    }

    /**
     * 根据手机号码获取验证码
     *
     * @return
     */
    @GetMapping("/getCode")
    public String getCode(String phone) {
        return sendyzmService.getCode(phone);
    }

    /**
     * 删除验证码
     *
     * @param phone
     * @return
     */
    @DeleteMapping("/deleteCode")
    public LzjResult deleteCode(String phone) {
        return sendyzmService.deleteCode(phone);
    }

}