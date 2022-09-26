package com.example.ivsserver.controller;

import com.example.ivsserver.common.Result;
import com.example.ivsserver.entity.purchaseOrder;
import com.example.ivsserver.mapper.purchaseOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public class purchaseOrderController {

    @Autowired
    purchaseOrderMapper purchaseOrderMapper;

    @RequestMapping(value = "/getInfoPurchaseOrder",method = RequestMethod.GET)
    public Result<?> getInfoPurchaseOrder(){
        List<purchaseOrder> list = purchaseOrderMapper.getInfoPurchaseOrder();
        return Result.success(list);
    }

    @RequestMapping(value = "/addPurchaseOrder",method = RequestMethod.POST)
    public Result<?> addPurchaseOrder(@RequestBody purchaseOrder purchaseOrder){
        purchaseOrderMapper.addPurchaseOrder(purchaseOrder);
        return Result.success();
    }

    @RequestMapping(value = "/deletePurchaseOrder",method = RequestMethod.GET)
    public Result<?> deletePurchaseOrder(@RequestParam String purchase_contract_id){
        purchaseOrderMapper.deletePurchaseOrder(purchase_contract_id);
        return Result.success();
    }

    @RequestMapping(value = "/updatePurchaseOrder",method = RequestMethod.PUT)
    public Result<?> updatePurchaseOrder(@RequestBody purchaseOrder purchaseOrder){
        purchaseOrderMapper.updatePurchaseOrder(purchaseOrder);
        return Result.success();
    }

    @RequestMapping(value = "/selectPurchaseOrder",method = RequestMethod.GET)
    public Result<?> selectPurchaseOrder(@RequestParam String purchase_contract_id){
        purchaseOrder purchaseOrder = purchaseOrderMapper.selectPurchaseOrder(purchase_contract_id);
        return Result.success(purchaseOrder);
    }



}
