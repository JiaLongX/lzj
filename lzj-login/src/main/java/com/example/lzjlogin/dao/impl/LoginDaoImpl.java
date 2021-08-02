package com.example.lzjlogin.dao.impl;

import com.example.lzjlogin.dao.LoginDao;
import com.example.lzjpojo.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * 录服务数据层
 */
@Repository
public class LoginDaoImpl implements LoginDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 新增登录日志到 MongoDB
     *
     * @param loginLog
     */
    @Override
    public void saveLoginLog(LoginLog loginLog) {
        mongoTemplate.save(loginLog);
    }

}