package com.example.ivsserver.controller;

import com.example.ivsserver.common.Result;
import com.example.ivsserver.entity.purchase;
import com.example.ivsserver.mapper.purchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class purchaseController {


    @Autowired
    purchaseMapper purchaseMapper;




    @RequestMapping(value = "/addPurchase",method = RequestMethod.POST)
    public Result<?> addPurchase(@RequestBody purchase purchase){
        purchaseMapper.addPurchase(purchase);
        return Result.success();
    }

    @RequestMapping(value = "/deletePurchase",method = RequestMethod.GET)
    public Result<?> deletePurchase(@RequestParam String purchase_contract_id){
        purchaseMapper.deletePurchase(purchase_contract_id);
        return Result.success();
    }

    @RequestMapping(value = "/updatePurchase",method = RequestMethod.PUT)
    public Result<?> updatePurchase(@RequestBody purchase purchase){
        purchaseMapper.updatePurchase(purchase);
        return Result.success();
    }

    @RequestMapping(value = "/selectPurchase",method = RequestMethod.GET)
    public Result<?> selectPurchase(@RequestParam String purchase_contract_id){
        purchase purchase = purchaseMapper.selectPurchase(purchase_contract_id);
        return Result.success(purchase);
    }

}
