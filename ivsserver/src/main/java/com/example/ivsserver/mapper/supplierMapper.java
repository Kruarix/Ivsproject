package com.example.ivsserver.mapper;

import com.example.ivsserver.entity.supplier;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface supplierMapper {

    void addSupplier(supplier supplier);

    void deleteSupplier(String supplier_id);

    void updateSupplier(supplier supplier);

    supplier selectSupplier(String supplier_name);

    List<supplier> getInfoSupplier();
}
