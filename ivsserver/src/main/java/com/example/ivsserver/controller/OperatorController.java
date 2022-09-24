package com.example.ivsserver.controller;


import com.example.ivsserver.common.Result;
import com.example.ivsserver.entity.operator;
import com.example.ivsserver.mapper.operatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class OperatorController {

    @Autowired
    operatorMapper operatorMapper;

    @RequestMapping(value = "/getInfoOperator",method = RequestMethod.GET)
    public Result<?> getInfoOperator(){
            List<operator> list = operatorMapper.getInfoOperator();
            for(int i=0;i<list.size();i++){
                if(list.get(i).getState().equals("1")){
                    list.get(i).setState("启用");
                }else if(list.get(i).getState().equals("0")){
                    list.get(i).setState("停用");
                }
            }
        return Result.success(list);
    }



}
