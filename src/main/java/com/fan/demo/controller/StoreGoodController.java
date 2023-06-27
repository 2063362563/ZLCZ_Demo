package com.fan.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fan.demo.pojo.StoreGood;
import com.fan.demo.service.StroeGoodService;
import com.fan.demo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store-good")
public class StoreGoodController {

    @Autowired
    private StroeGoodService stroeGoodService;

    /**
     * 出库
     * @param storeId
     * @param goodId
     * @param num
     * @return
     */
    @PutMapping("/outInventory")
    Result outInventory(Integer storeId, Integer goodId, Integer num){
        if (stroeGoodService.outInventory(storeId, goodId, num) == 0){
            return Result.error("库存不足!");
        }
        LambdaQueryWrapper<StoreGood> wrapper = new LambdaQueryWrapper<>();
        wrapper
                .eq(StoreGood::getStoreId,storeId)
                .eq(StoreGood::getGoodId,goodId);
        //新建operate

        return Result.success(stroeGoodService.getOne(wrapper).getGoodNum(),"出库成功!");
    }

    /**
     * 入库
     * @param storeId
     * @param goodId
     * @param num
     * @return
     */
    @PutMapping("/inInventory")
    Result inInventory(Integer storeId, Integer goodId, Integer num){
        stroeGoodService.inInventory(storeId, goodId, num);
        LambdaQueryWrapper<StoreGood> wrapper = new LambdaQueryWrapper<>();
        wrapper
                .eq(StoreGood::getStoreId,storeId)
                .eq(StoreGood::getGoodId,goodId);
        //新建operate

        return Result.success(stroeGoodService.getOne(wrapper).getGoodNum(),"入库成功!");
    }




}






















