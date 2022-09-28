package com.example.ivsserver.controller;

import com.example.ivsserver.common.Result;
import com.example.ivsserver.mapper.processingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class processingController {

    @Autowired
    processingMapper processingMapper;

    @RequestMapping(value = "/selectGoodsPurchase",method = RequestMethod.GET)
    public Result<?> selectGoodsPurchase(@RequestParam String goods_name){
        List<Map<String,Object>> list = processingMapper.selectGoodsPurchase(goods_name);

        return Result.success(list);
    }

    @RequestMapping(value = "/selectGoodsSales",method = RequestMethod.GET)
    public Result<?> selectGoodsSales(@RequestParam String goods_name){
        List<Map<String,Object>> list = processingMapper.selectGoodsSales(goods_name);

        return Result.success(list);
    }

    @RequestMapping(value = "/selectSupplierPurchase",method = RequestMethod.GET)
    public Result<?> selectSupplierPurchase(@RequestParam String supplier_name){
        List<Map<String,Object>> list = processingMapper.selectSupplierPurchase(supplier_name);

        return Result.success(list);
    }

    @RequestMapping(value = "/selectSupplierGoods",method = RequestMethod.GET)
    public Result<?> selectSupplierGoods(@RequestParam String goods_name){
        List<Map<String,Object>> list = processingMapper.selectSupplierGoods(goods_name);

        return Result.success(list);
    }




}
