package com.example.ivsserver.mapper;

import com.example.ivsserver.entity.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface purchaseInfoMapper {

    List<purchaseInfo> getInfoPurchase();

    List<purchaseInfoList> getInfoPurchaseList(String purchase_contract_id);

}
