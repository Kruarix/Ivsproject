package com.example.ivsserver.mapper;

import com.example.ivsserver.entity.operator;

import java.util.List;
import java.util.Map;

public interface operatorMapper {

    void addOperator(operator operator);

    void deleteOperator(String operator_id);

    void updateOperator(operator operator);
    operator selectOne(String username);

    List<operator> getInfoOperator();



}
