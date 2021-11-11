package com.cheng.yygh.cmn.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author nuonuo
 * @create 2021-11-11 20:01
 */
@MapperScan("com.cheng.yygh.cmn.mapper")
public class CmnConfig {

    /**
     * 分页插件
     */
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
