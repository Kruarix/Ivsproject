package com.example.ivsserver.entity;

import lombok.Data;

import java.util.List;

@Data
public class purchaseInfo {
    private String purchase_contract_id;
    private String delivery_date;
    private String supplier_name;
    private String operator_name;
    private List<purchaseInfoList> purchaseInfoList;

}
