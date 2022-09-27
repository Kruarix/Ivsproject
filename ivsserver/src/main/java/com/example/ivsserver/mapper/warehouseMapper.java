package com.example.ivsserver.mapper;

import com.example.ivsserver.entity.warehouse;

import java.util.List;

public interface warehouseMapper {

    void addWarehouse(warehouse warehouse);

    void deleteWarehouse(String goods_id);

    void updateWarehouse(warehouse warehouse);

    warehouse selectWarehouse(String goods_name);

    List<warehouse> getInfoWarehouse();

}
