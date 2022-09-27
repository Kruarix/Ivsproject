package com.example.ivsserver.controller;


import com.example.ivsserver.common.Result;
import com.example.ivsserver.entity.*;
import com.example.ivsserver.mapper.purchaseInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class purchaseInfoController {

    @Autowired
    purchaseInfoMapper purchaseInfoMapper;

    @RequestMapping(value = "/getInfoPurchase",method = RequestMethod.GET)
    public Result<?> getInfoPurchase(){
        List<Map<purchaseOrder,Objects>> list = purchaseInfoMapper.getInfoPurchase();


        return Result.success(list);
    }


}
