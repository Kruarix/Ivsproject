package com.example.ivsserver.controller;


import com.example.ivsserver.common.Result;
import com.example.ivsserver.entity.client;
import com.example.ivsserver.mapper.clientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    clientMapper clientMapper;

    @RequestMapping(value = "/getInfoClient",method = RequestMethod.GET)
    public Result<?> getInfoClient(){
        List<client> list = clientMapper.getInfoClient();
        return Result.success(list);
    }

    @RequestMapping(value = "/addClient",method = RequestMethod.POST)
    public Result<?> addClient(@RequestBody client client){
        clientMapper.addClient(client);
        return Result.success();
    }

    @RequestMapping(value = "/deleteClient",method = RequestMethod.GET)
    public Result<?> deleteClient(@RequestParam String client_id){
        clientMapper.deleteClient(client_id);
        return Result.success();
    }

    @RequestMapping(value = "/updateClient",method = RequestMethod.PUT)
    public Result<?> updateClient(@RequestBody client client){
        clientMapper.updateClient(client);
        return Result.success();
    }

    @RequestMapping(value = "/selectClient",method = RequestMethod.GET)
    public Result<?> selectClient(@RequestParam String name){
        client client = clientMapper.selectClient(name);
        return Result.success(client);
    }


}
