package com.eshop.eshoppriceservice.mapper;

import com.eshop.eshoppriceservice.model.ProductPrice;
import org.apache.ibatis.annotations.*;

public interface ProductPriceMapper {

    @Insert("insert into product_price(value, product_id) values(#{value}, #{productId})")
    @SelectKey(keyColumn = "id", keyProperty = "id", before = false, resultType = java.lang.Long.class, statement = "select last_insert_id()")
    void add(ProductPrice productPrice);

    @Update("update product_price set value=#{value},product_id=#{productId} where id=#{id}")
    void update(ProductPrice productPrice);

    @Delete("delete from product_price where id=#{id}")
    void delete(Long id);

    @Select("select * from product_price where id=#{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "value", property = "value"),
            @Result(column = "product_id", property = "productId")
    })
    ProductPrice findById(Long id);

    @Select("select * from product_price where product_id=#{productId}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "value", property = "value"),
            @Result(column = "product_id", property = "productId")
    })
    ProductPrice findByProductId(Long productId);
}
