package com.fan.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fan.demo.pojo.Operate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface OperateMapper extends BaseMapper<Operate> {

    //这里的io参数是一个布尔值,0代表入库1代表出库
    @Select("SELECT * from operate where good_id in (SELECT id FROM good WHERE name LIKE concat('%',#{goodName},'%')) and operating_time >= 2023-06-25 and io = #{io} limit ${(page-1)*size},size")
    List<Operate> getOperate(String goodName, Date date, Boolean io, Integer page, Integer size);

}
