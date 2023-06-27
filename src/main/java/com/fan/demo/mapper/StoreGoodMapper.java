package com.fan.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fan.demo.pojo.StoreGood;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StoreGoodMapper extends BaseMapper<StoreGood> {

    //出库,库存最小值为0
    @Update("UPDATE store_good SET good_num = good_num - #{num} WHERE store_id = #{storeId} AND good_id = #{goodId} AND good_num >= #{num}")
    Integer outInventory(Integer storeId, Integer goodId, Integer num);

    @Update("UPDATE store_good SET good_num = good_num + #{num} WHERE store_id = #{storeId} AND good_id = #{goodId}")
    //入库
    Integer inInventory(Integer storeId, Integer goodId, Integer num);


}
