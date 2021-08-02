package com.example.lzjsendyzm.dao;

import com.example.lzjpojo.ValidateCode;

/**
 * 验证码服务数据层
 */
public interface SendyzmDao {


    Boolean setCode(String phone, String code);

    /**
     * 获取验证码
     *
     * @param phone
     * @return
     */
    String getCode(String phone);

    /**
     * 删除验证码
     *
     * @param phone
     */
    boolean deleteCode(String phone);

}