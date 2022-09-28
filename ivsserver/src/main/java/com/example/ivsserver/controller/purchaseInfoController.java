package com.example.ivsserver.controller;


import com.example.ivsserver.common.Result;
import com.example.ivsserver.entity.*;
import com.example.ivsserver.mapper.purchaseInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class purchaseInfoController {

    @Autowired
    purchaseInfoMapper purchaseInfoMapper;

    @RequestMapping(value = "/getInfoPurchase",method = RequestMethod.GET)
    public Result<?> getInfoPurchase(){

        //订单信息数组输出
        List<purchaseInfo> list = purchaseInfoMapper.getInfoPurchase();
        for(int i=0;i<list.size();i++){
            list.get(i).setPurchaseInfoList(purchaseInfoMapper.getInfoPurchaseList(list.get(i).getPurchase_contract_id()));
        }

        return Result.success(list);
    }


}
