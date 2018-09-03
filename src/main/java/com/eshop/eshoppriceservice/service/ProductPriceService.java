package com.eshop.eshoppriceservice.service;

import com.eshop.eshoppriceservice.model.ProductPrice;

/**
 * 商品价格服务接口
 */
public interface ProductPriceService {

    void add(ProductPrice productPrice);

    void update(ProductPrice productPrice);

    void delete(Long id);

    ProductPrice findById(Long id);

    ProductPrice findByProductId(Long productId);
}
