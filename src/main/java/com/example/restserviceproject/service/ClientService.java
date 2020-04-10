package com.example.restserviceproject.service;

import com.example.restserviceproject.entity.Client;

import java.util.List;

public interface ClientService {
    List<Client> findAll();

    void insertClient(String fName, String lName, String sName);

    Boolean updateClient(Client client);

    Boolean deleteClient(Client client);


}
