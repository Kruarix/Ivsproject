package com.example.ivsserver.mapper;

import com.example.ivsserver.entity.salesOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface salesOrderMapper {

    void addSalesOrder(salesOrder salesOrder);

    void deleteSalesOrder(String sales_contract_id);

    void updateSalesOrder(salesOrder salesOrder);

    salesOrder selectSalesOrder(String sales_contract_id);

    List<salesOrder> getInfoSalesOrder();


}
