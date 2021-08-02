package com.example.lzjhotproduct.service;

import com.example.lzjcommons.result.LzjResult;

public interface HotProductService {
    LzjResult selectHotProduct(String city);
}
