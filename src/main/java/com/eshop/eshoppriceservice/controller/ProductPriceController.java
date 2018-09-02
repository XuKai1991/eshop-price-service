package com.eshop.eshoppriceservice.controller;

import com.eshop.eshoppriceservice.model.ProductPrice;
import com.eshop.eshoppriceservice.service.ProductPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-price")
public class ProductPriceController {

    @Autowired
    private ProductPriceService productPriceService;

    @GetMapping("/add")
    public String add(ProductPrice productPrice) {
        try {
            productPriceService.add(productPrice);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/update")
    public String update(ProductPrice productPrice) {
        try {
            productPriceService.update(productPrice);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/delete")
    public String delete(Long id) {
        try {
            productPriceService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/findById")
    public ProductPrice findById(Long id) {
        try {
            return productPriceService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ProductPrice();
    }

}
