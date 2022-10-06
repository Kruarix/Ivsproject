package com.example.ivsserver.mapper;

import com.example.ivsserver.entity.warehouse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface warehouseMapper {

    void addWarehouse(warehouse warehouse);

    void deleteWarehouse(String goods_id);

    void updateWarehouse(warehouse warehouse);

    warehouse selectWarehouse(String goods_name);

    List<warehouse> getInfoWarehouse();

}
