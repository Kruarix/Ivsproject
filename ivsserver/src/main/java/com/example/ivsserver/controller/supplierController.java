package com.example.ivsserver.controller;

import com.example.ivsserver.common.Result;
import com.example.ivsserver.common.RngUtil;
import com.example.ivsserver.entity.supplier;
import com.example.ivsserver.mapper.supplierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class supplierController {

    @Autowired
    supplierMapper supplierMapper;

    @RequestMapping(value = "/getInfoSupplier",method = RequestMethod.GET)
    public Result<?> getInfoSupplier(){
        List<supplier> list = supplierMapper.getInfoSupplier();
        return Result.success(list);
    }

    @RequestMapping(value = "/addSupplier",method = RequestMethod.POST)
    public Result<?> addSupplier(@RequestBody supplier supplier){
        //随机ID生成检测
        String Check;
        while(true){
            Check = RngUtil.randomAlphabetic();
            supplier supplierCheck = supplierMapper.selectSupplier(Check);
            if(supplierCheck==null){
                break;
            }
        }
        supplier.setSupplier_id(Check);

        supplierMapper.addSupplier(supplier);
        return Result.success();
    }

    @RequestMapping(value = "/deleteSupplier",method = RequestMethod.GET)
    public Result<?> deleteSupplier(@RequestParam String supplier_id){
        supplierMapper.deleteSupplier(supplier_id);
        return Result.success();
    }

    @RequestMapping(value = "/updateSupplier",method = RequestMethod.PUT)
    public Result<?> updateSupplier(@RequestBody supplier supplier){
        supplierMapper.updateSupplier(supplier);
        return Result.success();
    }

    @RequestMapping(value = "/selectSupplier",method = RequestMethod.GET)
    public Result<?> selectSupplier(@RequestParam String name){
        supplier supplier = supplierMapper.selectSupplier(name);
        return Result.success(supplier);
    }

}
