package com.example.ivsserver.mapper;

import com.example.ivsserver.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
import java.util.Objects;
@Mapper
public interface purchaseInfoMapper {

    List<purchaseInfo> getInfoPurchase();

    List<purchaseInfoList> getInfoPurchaseList(String purchase_contract_id);

}
