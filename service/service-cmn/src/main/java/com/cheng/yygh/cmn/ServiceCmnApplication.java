package com.cheng.yygh.cmn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author nuonuo
 * @create 2021-11-11 19:58
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.cheng"})
public class ServiceCmnApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceCmnApplication.class, args);
    }
}
