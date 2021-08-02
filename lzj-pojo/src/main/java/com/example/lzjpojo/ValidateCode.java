package com.example.lzjpojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidateCode implements Serializable {

    private String phone; // 手机号码
    private String code; // 验证码

}