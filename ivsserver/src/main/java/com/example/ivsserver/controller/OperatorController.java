package com.example.ivsserver.controller;


import com.example.ivsserver.common.Result;
import com.example.ivsserver.entity.operator;
import com.example.ivsserver.mapper.operatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/deleteOperator",method = RequestMethod.GET)
    public Result<?> deleteOperator(@RequestParam String operator_id){
        operatorMapper.deleteOperator(operator_id);
        return Result.success();
    }

    @RequestMapping(value = "/updateOperator",method = RequestMethod.PUT)
    public Result<?> updateOperator(@RequestBody operator operator){
        operatorMapper.updateOperator(operator);
        return Result.success();
    }




}
