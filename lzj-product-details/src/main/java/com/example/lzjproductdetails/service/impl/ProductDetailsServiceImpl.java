package com.example.lzjproductdetails.service.impl;

import com.example.lzjpojo.Item;
import com.example.lzjproductdetails.dao.ProductDetailsDao;
import com.example.lzjproductdetails.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {

    @Resource
    private ProductDetailsDao productDetailsDao;

    @Value("${fastdfs.storage.nginx.prefix:}")
    private String fastdfsStorageNginxPrefix;

    @Override
    @Cacheable(cacheNames = "com:xxxx:lzj:productDetails",key = "'selectItemById.'+#id+''")
    public Item selectItemById(String id) {
        Item item = productDetailsDao.selectItemById(id);
        if (item!=null) {
            List<String> imgs = new ArrayList<>();
            for (String img : item.getImgs()) {
                imgs.add(fastdfsStorageNginxPrefix+img);
            }
            item.setImgs(imgs);
        }
        return item;
    }
}
