package com.example.ivsserver.mapper;

import com.example.ivsserver.entity.salesInfo;
import com.example.ivsserver.entity.salesInfoList;

import java.util.List;

public interface salesInfoMapper {

    List<salesInfo> getInfoSales();

    List<salesInfoList> getInfoSalesList(String sales_contract_id);
}
