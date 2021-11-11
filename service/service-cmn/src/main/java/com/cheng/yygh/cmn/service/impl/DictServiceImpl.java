package com.cheng.yygh.cmn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cheng.yygh.cmn.mapper.DictMapper;
import com.cheng.yygh.cmn.service.DictService;
import com.cheng.yygh.entity.cmn.Dict;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nuonuo
 * @create 2021-11-11 20:04
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

    //根据数据id查询子数据列表
    @Override
    public List<Dict> findChildData(Long id) {
        QueryWrapper<Dict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", id);
        List<Dict> dicts = baseMapper.selectList(queryWrapper);
        //设置dict 的 hasChildren字段
        for (Dict dict : dicts) {
            Long dictId = dict.getId();
            dict.setHasChildren(this.isChildren(dictId));
        }

        return dicts;
    }

    //判断id下面是否有子数据
    private boolean isChildren(Long id) {
        QueryWrapper<Dict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", id);
        Integer count = baseMapper.selectCount(queryWrapper);
        return count > 0;
    }
}
