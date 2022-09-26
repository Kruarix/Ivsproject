package com.example.ivsserver.mapper;

import com.example.ivsserver.entity.sales;

import java.util.List;

public interface salesMapper {

    void addSales(sales sales);

    void deleteSales(String sales_contract_id);

    void updateSales(sales sales);

    sales selectSales(String sales_contract_id);

    List<sales> getInfoSales();
}
