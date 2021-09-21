package com.cheng.yygh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cheng.yygh.entity.hosp.HospitalSet;
import com.cheng.yygh.mapper.HospitalSetMapper;
import com.cheng.yygh.service.HospitalSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nuonuo
 * @create 2021-09-17 16:15
 */
@Service
public class HospitalSetServiceImpl extends ServiceImpl<HospitalSetMapper, HospitalSet> implements HospitalSetService {//这里非要实现方法

    @Autowired
    private HospitalSetMapper hospitalSetMapper;
}




