package com.cheng.yygh.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author nuonuo
 * @create 2021-09-17 18:50
 */
@Configuration
@MapperScan("com.cheng.yygh.mapper")
public class HospitalConfig {
    /**
     * 分页插件
     */
//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//        return new PaginationInterceptor();
//    }

}
