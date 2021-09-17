package com.cheng.yygh.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Mybatis plus Handler配置类
 *
 * @author nuonuo
 * @create 2021-09-17 13:41
 */
@Component
public class CommonMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) { //插入行时执行
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) { //更新行时执行
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }

}
