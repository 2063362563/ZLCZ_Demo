package com.fan.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @description 商品的种类
 * @author fan
 * @date 2023-06-26
 */
@Data
public class Type implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * 种类id
     */
    private Integer id;

    /**
     * 种类名称
     */
    private String type;

    public Type() {}
}