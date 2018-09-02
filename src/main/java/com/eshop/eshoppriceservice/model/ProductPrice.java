package com.eshop.eshoppriceservice.model;

import lombok.Data;

/**
 * 商品价格实体类
 */
@Data
public class ProductPrice {

    private Long id;

    private Double value;

    private Long productId;

}
