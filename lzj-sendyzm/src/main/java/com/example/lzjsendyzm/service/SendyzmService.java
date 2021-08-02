package com.example.lzjsendyzm.service;

import com.example.lzjcommons.result.LzjResult;

public interface SendyzmService {
    LzjResult sendyzm(String phone);

    String getCode(String phone);

    LzjResult deleteCode(String phone);
}
