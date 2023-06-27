package com.fan.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fan.demo.pojo.StoreGood;

public interface StroeGoodService extends IService<StoreGood> {

    Integer inInventory(Integer storeId, Integer goodId, Integer num);

    Integer outInventory(Integer storeId, Integer goodId, Integer num);

}
