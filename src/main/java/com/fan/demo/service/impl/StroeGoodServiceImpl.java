package com.fan.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fan.demo.mapper.StoreGoodMapper;
import com.fan.demo.pojo.StoreGood;
import com.fan.demo.service.StroeGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StroeGoodServiceImpl extends ServiceImpl<StoreGoodMapper, StoreGood> implements StroeGoodService {

    @Autowired
    private StoreGoodMapper storeGoodMapper;


    @Override
    public Integer inInventory(Integer storeId, Integer goodId, Integer num) {
        storeGoodMapper.inInventory(storeId,goodId,num);
        return null;
    }

    @Override
    public Integer outInventory(Integer storeId, Integer goodId, Integer num) {
        storeGoodMapper.outInventory(storeId,goodId,num);
        return null;
    }
}
