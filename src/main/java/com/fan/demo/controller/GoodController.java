package com.fan.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fan.demo.pojo.Good;
import com.fan.demo.service.GoodService;
import com.fan.demo.utils.RedisCache;
import com.fan.demo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("/good")
public class GoodController {

    @Autowired
    private GoodService goodService;

    @Autowired
    private RedisCache redisCache;

    /**
     * 新增商品
     * @param good
     * @return
     */
    @PostMapping("/save")
    public Result save(@RequestBody Good good){
        if (good == null){
            return Result.error("传入商品为空!");
        }
        good.setCreateTime(LocalDateTime.now());
        String goodId = good.getId().toString();
        redisCache.setCacheObject(goodId,good,2, TimeUnit.HOURS);
        return Result.success(goodService.save(good),"新增成功!");
    }

    /**
     * 修改商品
     * @param good
     * @return
     */
    @PutMapping("/update")
    public Result update(@RequestBody Good good){
        if (good == null){
            return Result.error("传入商品为空!");
        }
        String goodId = good.getId().toString();
        redisCache.setCacheObject(goodId,good,2, TimeUnit.HOURS);
        return Result.success(goodService.updateById(good),"修改成功!");
    }

    /**
     * 删除商品
     * @param goodId
     * @return
     */
    @DeleteMapping("/{goodId}")
    public Result remove(@PathVariable Integer goodId){
        if (goodService.removeById(goodId)){
            redisCache.deleteObject(goodId.toString());
            return Result.success("删除成功!");
        }else {
            return Result.error("删除失败!");
        }
    }

    /**
     * 根据ID查找商品
     * @param goodId
     * @return
     */
    @GetMapping("/{goodId}")
    public Result getGoodById(@PathVariable Integer goodId){
        Good redisGood = redisCache.getCacheObject(goodId.toString());
        if (redisGood != null){
            return Result.success(redisGood,"查询成功!");
        }
        LambdaQueryWrapper<Good> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Good::getId,goodId);
        final Good good = goodService.getOne(wrapper);
        if (good == null){
            return Result.error("查询不到该商品!");
        }
        redisCache.setCacheObject(goodId.toString(),good,2, TimeUnit.HOURS);
        return Result.success(good,"查询成功!");
    }

    /**
     * 分页展示查找的商品
     * @param name
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/get_good_by_name")
    @ResponseBody
    public Result getGoodByName(String name, Integer page, Integer size) {
        Page<Good> redisGoodPage = redisCache.getCacheObject(name+page);
        if (redisGoodPage != null){
            return Result.success(redisGoodPage,"查询成功!");
        }
        LambdaQueryWrapper<Good> wrapper = new LambdaQueryWrapper<>();
        if (name != null) {
            wrapper.like(Good::getName, name);
        }
        wrapper.orderByDesc(Good::getCreateTime);
        Page<Good> goodPage = goodService.page(new Page<>(page, size), wrapper);
        redisCache.setCacheObject(name+page,goodPage,2,TimeUnit.HOURS);
        return Result.success(goodPage);
    }
}
