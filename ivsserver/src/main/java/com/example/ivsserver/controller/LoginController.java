package com.example.ivsserver.controller;


import com.example.ivsserver.common.Result;
import com.example.ivsserver.common.RngUtil;
import com.example.ivsserver.entity.operator;
import com.example.ivsserver.mapper.operatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {


    @Autowired
    private operatorMapper operatorMapper;



    @RequestMapping(value = "selectOperator", method = RequestMethod.POST)
    public Result<?> selectOperator(@RequestBody operator operator){

        System.out.println(operator.toString());

        operator operatorCheck = operatorMapper.selectOperator(operator.getUsername());
        if(operatorCheck!=null){
            return Result.success(operator);
        }
        return Result.error();
    }










}
