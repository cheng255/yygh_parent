package com.cheng.yygh.cmn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cheng.yygh.entity.cmn.Dict;

import java.util.List;

/**
 * @author nuonuo
 * @create 2021-11-11 20:03
 */
public interface DictService extends IService<Dict> {

    List<Dict> findChildData(Long id);
}
