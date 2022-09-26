package com.example.ivsserver.controller;


import com.example.ivsserver.common.Result;
import com.example.ivsserver.entity.operator;
import com.example.ivsserver.mapper.operatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {


    @Autowired
    private operatorMapper operatorMapper;

    @RequestMapping(value = "/addOperator",method = RequestMethod.GET)
    public void addOperator(){
        operator operator = new operator();
        operator.setOperator_id("X001");
        operator.setName("王二");
        operator.setState("1");
        operator.setUsername("we");
        operator.setPassword("123");

        operatorMapper.addOperator(operator);
    }

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
