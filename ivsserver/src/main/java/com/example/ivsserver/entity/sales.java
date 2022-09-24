package com.example.ivsserver.entity;

import lombok.Data;

@Data
public class sales {

    private String sales_contract_id;
    private String goods_id;
    private int quantity;
    private double unit_price;
}
