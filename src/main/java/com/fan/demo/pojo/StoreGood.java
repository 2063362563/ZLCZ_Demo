package com.fan.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @description 门店与商品库存的关系
 * @author fan
 * @date 2023-06-26
 */
@Data
public class StoreGood implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * 门店id
     */
    private Integer storeId;

    /**
     * 商品id
     */
    private Integer goodId;

    /**
     * 商品数
     */
    private Integer goodNum;

    public StoreGood() {}
}