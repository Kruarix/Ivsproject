package com.example.ivsserver.entity;

import lombok.Data;

import java.util.List;
@Data
public class salesInfo {

    private String sales_contract_id;
    private String sale_date;
    private String client_name;
    private String operator_name;
    private List<salesInfoList> salesInfoList;
}
