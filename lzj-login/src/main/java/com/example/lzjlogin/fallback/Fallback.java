package com.example.lzjlogin.fallback;

import com.example.lzjcommons.result.LzjResult;
import com.example.lzjlogin.service.SendyzmService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class Fallback implements FallbackFactory<SendyzmService> {
    @Override
    public SendyzmService create(Throwable throwable) {
        return new SendyzmService() {
            @Override
            public String getCode(String phone) {
                return "error";
            }

            @Override
            public LzjResult deleteCode(String phone) {
                return null;
            }
        };
    }
}
