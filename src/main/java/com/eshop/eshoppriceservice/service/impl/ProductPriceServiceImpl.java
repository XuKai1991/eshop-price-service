package com.eshop.eshoppriceservice.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.eshop.eshoppriceservice.mapper.ProductPriceMapper;
import com.eshop.eshoppriceservice.model.ProductPrice;
import com.eshop.eshoppriceservice.service.ProductPriceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 商品价格服务实现类
 */
@Service
public class ProductPriceServiceImpl implements ProductPriceService {

    @Autowired
    private ProductPriceMapper productPriceMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void add(ProductPrice productPrice) {
        productPriceMapper.add(productPrice);
        redisTemplate.opsForValue().set("product_price:" + productPrice.getProductId(), JSONObject.toJSONString(productPrice));
    }

    @Override
    public void update(ProductPrice productPrice) {
        productPriceMapper.update(productPrice);
        redisTemplate.opsForValue().set("product_price:" + productPrice.getProductId(), JSONObject.toJSONString(productPrice));
    }

    @Override
    public void delete(Long id) {
        ProductPrice productPrice = productPriceMapper.findById(id);
        productPriceMapper.delete(id);
        redisTemplate.opsForValue().getOperations().delete("product_price:" + productPrice.getProductId());
    }

    @Override
    public ProductPrice findById(Long id) {
        return productPriceMapper.findById(id);
    }

    @Override
    public ProductPrice findByProductId(Long productId) {
        String productPriceJsonStr = redisTemplate.opsForValue().get("product_price:" + productId);
        if (StringUtils.isNotEmpty(productPriceJsonStr)) {
            return JSONObject.parseObject(productPriceJsonStr, ProductPrice.class);
        }
        return productPriceMapper.findByProductId(productId);
    }

}
