package com.example.ivsserver.controller;

import com.example.ivsserver.common.Result;
import com.example.ivsserver.entity.warehouse;
import com.example.ivsserver.mapper.warehouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class warehouseController {

    @Autowired
    warehouseMapper warehouseMapper;

    @RequestMapping(value = "/getInfoWarehouse",method = RequestMethod.GET)
    public Result<?> getInfoWarehouse(){
        List<warehouse> list = warehouseMapper.getInfoWarehouse();
        return Result.success(list);
    }

    @RequestMapping(value = "/addWarehouse",method = RequestMethod.POST)
    public Result<?> addWarehouse(@RequestBody warehouse warehouse){
        warehouseMapper.addWarehouse(warehouse);
        return Result.success();
    }

    @RequestMapping(value = "/deleteWarehouse",method = RequestMethod.GET)
    public Result<?> deleteWarehouse(@RequestParam String goods_id){
        warehouseMapper.deleteWarehouse(goods_id);
        return Result.success();
    }

    @RequestMapping(value = "/updateWarehouse",method = RequestMethod.PUT)
    public Result<?> updateWarehouse(@RequestBody warehouse warehouse){
        warehouseMapper.updateWarehouse(warehouse);
        return Result.success();
    }

    @RequestMapping(value = "/selectWarehouse",method = RequestMethod.GET)
    public Result<?> selectWarehouse(@RequestParam String name){
        warehouse warehouse = warehouseMapper.selectWarehouse(name);
        return Result.success(warehouse);
    }

}
