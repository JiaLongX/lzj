package com.example.lzjcommons.result;


import com.example.lzjcommons.enums.lzjResultEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LzjResult implements Serializable {

    // 响应状态码，成功 200 失败 500
    private int status;
    // 返回结果数据。Banner轮播使用时，用于保存图片地址集合
    private Object data;
    // 提示消息。Banner轮播使用时，用于查询错误时返回提示信息
    private String msg;

    // 成功返回的对象
    public static LzjResult success() {
        LzjResult lzjResult = new LzjResult();
        lzjResult.setStatus(lzjResultEnum.SUCESS.getStatus());
        lzjResult.setMsg(lzjResultEnum.SUCESS.getMsg());
        return lzjResult;
    }

    // 成功返回的对象
    public static LzjResult success(String msg) {
        LzjResult lzjResult = new LzjResult();
        lzjResult.setStatus(lzjResultEnum.SUCESS.getStatus());
        lzjResult.setMsg(msg);
        return lzjResult;
    }

    // 成功返回的对象
    public static LzjResult success(String msg, Object result) {
        LzjResult lzjResult = new LzjResult();
        lzjResult.setStatus(lzjResultEnum.SUCESS.getStatus());
        lzjResult.setMsg(msg);
        lzjResult.setData(result);
        return lzjResult;
    }

    // 失败返回对象
    public static LzjResult error() {
        LzjResult lzjResult = new LzjResult();
        lzjResult.setStatus(lzjResultEnum.ERROR.getStatus());
        lzjResult.setMsg(lzjResultEnum.ERROR.getMsg());
        return lzjResult;
    }

    // 失败返回对象
    public static LzjResult error(String msg) {
        LzjResult lzjResult = new LzjResult();
        lzjResult.setStatus(lzjResultEnum.ERROR.getStatus());
        lzjResult.setMsg(msg);
        return lzjResult;
    }

    // 失败返回对象
    public static LzjResult error(String msg, Object result) {
        LzjResult lzjResult = new LzjResult();
        lzjResult.setStatus(lzjResultEnum.ERROR.getStatus());
        lzjResult.setMsg(msg);
        lzjResult.setData(result);
        return lzjResult;
    }

}