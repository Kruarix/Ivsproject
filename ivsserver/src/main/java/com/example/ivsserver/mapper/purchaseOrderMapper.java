package com.example.ivsserver.mapper;

import com.example.ivsserver.entity.purchaseOrder;

import java.util.List;

public interface purchaseOrderMapper {

    void addPurchaseOrder(purchaseOrder purchaseOrder);

    void deletePurchaseOrder(String purchase_contract_id);

    void updatePurchaseOrder(purchaseOrder purchaseOrder);

    purchaseOrder selectPurchaseOrder(String purchase_contract_id);

    List<purchaseOrder> getInfoPurchaseOrder();


}
