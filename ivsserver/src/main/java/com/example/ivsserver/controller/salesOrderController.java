package com.example.ivsserver.controller;

import com.example.ivsserver.common.Result;
import com.example.ivsserver.entity.salesOrder;
import com.example.ivsserver.mapper.salesOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class salesOrderController {

    @Autowired
    salesOrderMapper salesOrderMapper;

    @RequestMapping(value = "/getInfoSalesOrder",method = RequestMethod.GET)
    public Result<?> getInfoSalesOrder(){
        List<salesOrder> list = salesOrderMapper.getInfoSalesOrder();
        return Result.success(list);
    }

    @RequestMapping(value = "/addSalesOrder",method = RequestMethod.POST)
    public Result<?> addSalesOrder(@RequestBody salesOrder salesOrder){
        salesOrderMapper.addSalesOrder(salesOrder);
        return Result.success();
    }

    @RequestMapping(value = "/deleteSalesOrder",method = RequestMethod.GET)
    public Result<?> deleteSalesOrder(@RequestParam String sales_contract_id){
        salesOrderMapper.deleteSalesOrder(sales_contract_id);
        return Result.success();
    }

    @RequestMapping(value = "/updateSalesOrder",method = RequestMethod.PUT)
    public Result<?> updateSalesOrder(@RequestBody salesOrder salesOrder){
        salesOrderMapper.updateSalesOrder(salesOrder);
        return Result.success();
    }

    @RequestMapping(value = "/selectSalesOrder",method = RequestMethod.GET)
    public Result<?> selectSalesOrder(@RequestParam String sales_contract_id){
        salesOrder salesOrder = salesOrderMapper.selectSalesOrder(sales_contract_id);
        return Result.success(salesOrder);
    }



}
