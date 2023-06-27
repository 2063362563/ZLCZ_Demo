package com.fan.demo.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.io.Serializable;
import java.time.LocalDateTime;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
/**
 * @description 商品
 * @author fan
 * @date 2023-06-26
 */
@Data
public class Good implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * 商品id
     */
    private Integer id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 商品录入时间
     */
    private LocalDateTime createTime;

    /**
     * 商品种类
     */
    private Integer typeId;

    public Good() {}
}