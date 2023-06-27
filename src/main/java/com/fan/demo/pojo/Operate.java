package com.fan.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @description 出入库的操作记录
 * @author fan
 * @date 2023-06-27
 */
@Data
public class Operate implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * id
     */
    private Integer id;

    /**
     * 1表示出库，0表示入库
     */
    private Boolean io;

    /**
     * 操作时间
     */
    private LocalDateTime operatingTime;

    /**
     * 门店id
     */
    private Integer storeId;

    /**
     * 商品id
     */
    private Integer goodId;

    /**
     * 本次变化库存量
     */
    private Integer num;

    public Operate() {}
}