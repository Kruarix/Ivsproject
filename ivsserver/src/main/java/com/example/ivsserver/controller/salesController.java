package com.example.ivsserver.controller;

import com.example.ivsserver.common.Result;
import com.example.ivsserver.entity.sales;
import com.example.ivsserver.mapper.salesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class salesController {

    @Autowired
    salesMapper salesMapper;


//    @RequestMapping(value = "/getInfoSales",method = RequestMethod.GET)
//    public Result<?> getInfoSales(){
//        List<sales> list = salesMapper.getInfoSales();
//        return Result.success(list);
//    }

    @RequestMapping(value = "/addSales",method = RequestMethod.POST)
    public Result<?> addSales(@RequestBody sales sales){
        salesMapper.addSales(sales);
        return Result.success();
    }

    @RequestMapping(value = "/deleteSales",method = RequestMethod.GET)
    public Result<?> deleteSales(@RequestParam String sales_contract_id){
        salesMapper.deleteSales(sales_contract_id);
        return Result.success();
    }

    @RequestMapping(value = "/updateSales",method = RequestMethod.PUT)
    public Result<?> updateSales(@RequestBody sales sales){
        salesMapper.updateSales(sales);
        return Result.success();
    }

    @RequestMapping(value = "/selectSales",method = RequestMethod.GET)
    public Result<?> selectSales(@RequestParam String purchase_contract_id){
        sales sales = salesMapper.selectSales(purchase_contract_id);
        return Result.success(sales);
    }

}
