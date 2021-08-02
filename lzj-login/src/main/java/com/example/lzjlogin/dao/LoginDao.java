package com.example.lzjlogin.dao;

import com.example.lzjpojo.LoginLog;

/**
 * 登录服务数据层
 */
public interface LoginDao {

    /**
     * 新增登录日志到 MongoDB
     *
     * @param loginLog
     */
    void saveLoginLog(LoginLog loginLog);

}