package com.example.ivsserver.mapper;

import com.example.ivsserver.entity.purchase;

import java.util.List;

public interface purchaseMapper {

    void addPurchase(purchase purchase);

    void deletePurchase(String purchase_contract_id);

    void updatePurchase(purchase purchase);

    purchase selectPurchase(String purchase_contract_id);

    List<purchase> getInfoPurchase();


}
