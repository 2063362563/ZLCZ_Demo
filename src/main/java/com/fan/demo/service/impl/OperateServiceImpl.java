package com.fan.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fan.demo.mapper.OperateMapper;
import com.fan.demo.pojo.Operate;
import com.fan.demo.service.OperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OperateServiceImpl extends ServiceImpl<OperateMapper, Operate> implements OperateService {

    @Autowired
    private OperateMapper operateMapper;


    @Override
    public List<Operate> getOperate(String goodName, Date date, Boolean io, Integer page,Integer size) {
        return operateMapper.getOperate(goodName,date,io,page,size);
    }
}
