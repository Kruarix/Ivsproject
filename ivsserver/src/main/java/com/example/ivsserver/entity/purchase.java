package com.example.ivsserver.entity;

import lombok.Data;

@Data
public class purchase {

    private String purchase_contract_id;
    private String goods_id;
    private int quantity;
    private double unit_price;



}


