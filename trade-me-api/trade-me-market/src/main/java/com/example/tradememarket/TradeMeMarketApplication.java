package com.example.tradememarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.example.tradememarket.proxy")
public class TradeMeMarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradeMeMarketApplication.class, args);
    }

}
