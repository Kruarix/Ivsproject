package com.example.ivsserver.mapper;

import com.example.ivsserver.entity.operator;

import java.util.List;

public interface operatorMapper {

    void addOperator(operator operator);
    void deleteOperator(String operator_id);
    void updateOperator(operator operator);
    operator selectOperator(String username);
    List<operator> getInfoOperator();



}
