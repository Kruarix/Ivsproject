package com.example.ivsserver.entity;

import lombok.Data;

@Data
public class purchaseOrder {

    private String purchase_contract_id;
    private String delivery_date;
    private String supplier_id;
    private String operator_id;

}
