package com.eshop.eshoppriceservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
@EnableDiscoveryClient
@MapperScan(basePackages = "com.eshop.eshoppriceservice.mapper")
public class EshopPriceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopPriceServiceApplication.class, args);
    }
}
