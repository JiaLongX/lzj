package com.example.lzjlogin.service.impl;

import com.example.lzjcommons.result.LzjResult;
import com.example.lzjlogin.dao.LoginDao;
import com.example.lzjlogin.service.LoginService;
import com.example.lzjlogin.service.SendyzmService;
import com.example.lzjpojo.LoginLog;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginDao loginDao;

    @Resource
    private SendyzmService sendyzmService;

    @Override
    public LzjResult login(String username, String password) {
        LzjResult result = LzjResult.error();
        String code = sendyzmService.getCode(username);
        if (code.equals("error"))creatlog(username,"远程服务异常",false);

        else if (code==null)creatlog(username,"验证码已过期",false);
        else if (!password.equals(code)){
            creatlog(username,"验证码错误",false);
        }else {
            creatlog(username,"success",true);
            sendyzmService.deleteCode(username);
            result=LzjResult.success();
        }
        return result;
    }

    private void creatlog(String username, String info,Boolean tf) {
        LoginLog loginLog = new LoginLog();
        loginLog.setLoginTime(new Date());
        loginLog.setIsSuccess(tf);
        loginLog.setMessage(info);
        loginLog.setUsername(username);
        loginLog.setType("2");
        loginDao.saveLoginLog(loginLog);
    }

}
