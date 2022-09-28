package com.example.ivsserver.controller;

import com.example.ivsserver.common.Result;
import com.example.ivsserver.entity.salesInfo;
import com.example.ivsserver.mapper.salesInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class salesInfoController {

    @Autowired
    salesInfoMapper salesInfoMapper;

    @RequestMapping(value = "/getInfoSales",method = RequestMethod.GET)
    public Result<?> getInfoSales(){

        //订单信息数组输出
        List<salesInfo> list = salesInfoMapper.getInfoSales();
        for(int i=0;i<list.size();i++){
            list.get(i).setSalesInfoList(salesInfoMapper.getInfoSalesList(list.get(i).getSales_contract_id()));
        }

        return Result.success(list);
    }

}
