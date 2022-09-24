package com.example.ivsserver.entity;

import lombok.Data;

@Data
public class sales_order {


    private String sales_contract_id;
    private String sale_date;
    private String client_id;
    private String operator_id;

}
