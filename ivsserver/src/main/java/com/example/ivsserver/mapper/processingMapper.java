package com.example.ivsserver.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
import java.util.Objects;
@Mapper
public interface processingMapper {

    List<Map<String, Object>> selectGoodsPurchase(String goods_name);

    List<Map<String, Object>> selectGoodsSales(String goods_name);

    List<Map<String, Object>> selectSupplierPurchase(String supplier_name);

    List<Map<String, Object>> selectSupplierGoods(String goods_name);

}
