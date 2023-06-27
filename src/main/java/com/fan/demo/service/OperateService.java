package com.fan.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fan.demo.pojo.Operate;


import java.util.Date;
import java.util.List;


public interface OperateService extends IService<Operate> {

    List<Operate> getOperate(String goodName, Date date, Boolean io, Integer page, Integer size);

}