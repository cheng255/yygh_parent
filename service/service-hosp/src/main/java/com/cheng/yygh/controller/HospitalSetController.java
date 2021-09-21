package com.cheng.yygh.controller;

import com.cheng.yygh.entity.hosp.HospitalSet;
import com.cheng.yygh.service.HospitalSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author nuonuo
 * @create 2021-09-17 18:44
 */
@RestController
@RequestMapping("/admin/hosp/hospitalSet")
public class HospitalSetController {
    @Autowired
    private HospitalSetService hospitalSetService;

    //1.查询所有信息

    @GetMapping("findAll")
    public List<HospitalSet> findAllHospitalSet() {
        List<HospitalSet> list = hospitalSetService.list();
        return list;
    }

    //2.删除操作

    @DeleteMapping("{id}")
    public boolean deleteHospSet(@PathVariable Long id) {
        boolean b = hospitalSetService.removeById(id);
        return b;
    }

}
