package com.fan.demo.controller;


import com.fan.demo.service.OperateService;
import com.fan.demo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.Date;

@RestController
@RequestMapping("/operate")
public class OperateController {

    @Autowired
    private OperateService operateService;

    /**
     * 商品入库流水查询
     * @param goodName
     * @param date
     * @param page
     * @param size
     * @return
     */
    @GetMapping()
    @ResponseBody
    Result getOperate(String goodName, Date date, Integer page, Integer size){
        return Result.success(operateService.getOperate(goodName,date,false,page,size),"查询成功!");
    }

}
