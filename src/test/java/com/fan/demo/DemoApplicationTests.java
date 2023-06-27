package com.fan.demo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fan.demo.pojo.Good;
import com.fan.demo.service.GoodService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private GoodService goodService;
    @Test
    void contextLoads() {
        LambdaQueryWrapper<Good> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Good::getName, "可乐");
        wrapper.orderByDesc(Good::getCreateTime);
        Page<Good> goodList = new Page<>(2, 3);
        Page<Good> goodPage = goodService.page(goodList, wrapper);

        System.out.println(goodPage.getRecords());
        System.out.println(goodPage);
    }

}
