package com.example.ivsserver.mapper;

import com.example.ivsserver.entity.client;

import java.util.List;

public interface clientMapper {

    void addClient(client client);

    void deleteClient(String client_id);

    void updateClient(client client);

    client selectClient(String name);

    List<client> getInfoClient();
}
