package com.cheng.yygh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author nuonuo
 * @create 2021-09-17 15:27
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.cheng")
public class ServiceHospApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceHospApplication.class, args);
    }
}
