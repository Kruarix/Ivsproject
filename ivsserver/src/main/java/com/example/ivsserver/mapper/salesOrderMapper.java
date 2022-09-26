package com.example.ivsserver.mapper;

import com.example.ivsserver.entity.salesOrder;

import java.util.List;

public interface salesOrderMapper {

    void addSalesOrder(salesOrder salesOrder);

    void deleteSalesOrder(String sales_contract_id);

    void updateSalesOrder(salesOrder salesOrder);

    salesOrder selectSalesOrder(String sales_contract_id);

    List<salesOrder> getInfoSalesOrder();


}
