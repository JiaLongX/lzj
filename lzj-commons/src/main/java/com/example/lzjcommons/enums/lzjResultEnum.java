package com.example.lzjcommons.enums;

/**
 * 为什么使用枚举类？
 * 1. 提升代码的阅读性，避免硬编码。
 * 2. 程序解耦
 */
public enum lzjResultEnum {

    // 自定义枚举类
    SUCESS(200, "成功"),
    ERROR(500, "失败");

    private Integer status;
    private String msg;

    lzjResultEnum(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}