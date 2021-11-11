package com.cheng.yygh.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cheng.yygh.common.result.Result;
import com.cheng.yygh.entity.hosp.HospitalSet;
import com.cheng.yygh.service.HospitalSetService;
import com.cheng.yygh.vo.hosp.HospitalSetQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

/**
 * @author nuonuo
 * @create 2021-09-17 18:44
 */

@CrossOrigin
@Api(tags = "医院设置管理")
@RestController
@RequestMapping("/admin/hosp/hospitalSet")
public class HospitalSetController {
    @Autowired
    private HospitalSetService hospitalSetService;

    //1.查询所有信息
    @ApiOperation(value = "获取所有医院设置")
    @GetMapping("findAll")
    public Result findAllHospitalSet() {
        List<HospitalSet> list = hospitalSetService.list();
        return Result.ok(list);
    }

    //2.删除操作
    @ApiOperation(value = "逻辑删除医院设置")
    @DeleteMapping("{id}")
    public Result deleteHospSet(@ApiParam(name = "id", value = "医院设置id", required = true)
                                     @PathVariable Long id) {
        boolean b = hospitalSetService.removeById(id);
        if (b) {
            return Result.ok();
        }
        return Result.fail();
    }

    //3.条件查询 带分页
    @PostMapping("findPageHospSet/{current}/{limit}")
    public Result findPageHospSet(@PathVariable long current,
                                             @PathVariable long limit,
                                             @RequestBody(required = false)
                                                     HospitalSetQueryVo hospitalSetQueryVo) {
        Page<HospitalSet> page = new Page<>(current, limit);
        QueryWrapper<HospitalSet> queryWrapper = new QueryWrapper<>();
        String hosname = hospitalSetQueryVo.getHosname();
        String hoscode = hospitalSetQueryVo.getHoscode();
        if (!StringUtils.isEmpty(hoscode)) {
            queryWrapper.eq("hoscode", hoscode);
        }
        if (!StringUtils.isEmpty(hosname)) {
            queryWrapper.like("hosname", hosname);
        }
        Page<HospitalSet> hospitalSetPage = hospitalSetService.page(page, queryWrapper);
        return Result.ok(hospitalSetPage);
    }
    //4 添加医院设置
    @PostMapping("saveHospitalSet")
    public Result saveHospitalSet(@RequestBody HospitalSet hospitalSet) {
        hospitalSet.setStatus(1);
        Random random = new Random();

        hospitalSet.setSignKey(System.currentTimeMillis() + "" + random.nextInt(1000));

        boolean save = hospitalSetService.save(hospitalSet);
        if (save) {
            return Result.ok();
        }
        return Result.fail();
    }
    //5 根据id获取医院设置
    @ApiOperation(value = "根据id获取医院设置")
    @GetMapping("getHosSet/{id}")
    public Result getHosSet(@ApiParam(name = "id", value = "医院设置id", required = true)
                                    @PathVariable("id") Long id) {
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        return Result.ok(hospitalSet);
    }
    //6 修改医院设置
    @PostMapping("updateHosSet")
    public Result updateHosSet(@RequestBody HospitalSet hospitalSet) {
        boolean flag = hospitalSetService.updateById(hospitalSet);
        if (flag) {
            return Result.ok();
        }
        return Result.fail();
    }
    //7 批量删除医院设置
    @DeleteMapping("batchRemove")
    public Result batchRemoveHospitalSet(@RequestBody List<Long> ids) {
        boolean b = hospitalSetService.removeByIds(ids);
//        if (b) {
//            return Result.ok();
//        }
        return Result.ok();
    }

    //8 医院设置锁定和解锁
    @PutMapping("lockHospitalSet/{id}/{status}")
    public Result lockHospitalSet(@PathVariable Long id,
                                  @PathVariable Integer status) {
        //根据id查询医院设置信息
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        //设置状态
        hospitalSet.setStatus(status);
        //调用方法
        hospitalSetService.updateById(hospitalSet);
        return Result.ok();
    }

    //9. 发送签名密钥
    @PutMapping("sendKey/{id}")
    public Result lockHospitalSet(@PathVariable Long id) {
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        String signKey = hospitalSet.getSignKey();
        String hoscode = hospitalSet.getHoscode();
        //TODO 发送信息
        return Result.ok();
    }




}
