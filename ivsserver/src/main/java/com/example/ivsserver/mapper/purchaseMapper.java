package com.example.ivsserver.mapper;

import com.example.ivsserver.entity.purchase;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface purchaseMapper {

    void addPurchase(purchase purchase);

    void deletePurchase(String purchase_contract_id);

    void updatePurchase(purchase purchase);

    purchase selectPurchase(String purchase_contract_id);

    List<purchase> getInfoPurchase();


}
