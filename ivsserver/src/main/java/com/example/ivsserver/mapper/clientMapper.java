package com.example.ivsserver.mapper;

import com.example.ivsserver.entity.client;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface clientMapper {

    void addClient(client client);

    void deleteClient(String client_id);

    void updateClient(client client);

    client selectClient(String client_name);

    List<client> getInfoClient();
}
