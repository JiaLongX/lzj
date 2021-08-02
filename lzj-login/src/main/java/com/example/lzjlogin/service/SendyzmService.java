package com.example.lzjlogin.service;

import com.example.lzjcommons.result.LzjResult;
import com.example.lzjlogin.fallback.Fallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "lzj-sendyzm",fallbackFactory = Fallback.class)
public interface SendyzmService {

    @GetMapping("/sendyzm/getCode")
    String getCode(@RequestParam("phone") String phone);

    @DeleteMapping("/sendyzm/deleteCode")
    LzjResult deleteCode(@RequestParam("phone") String phone);
}