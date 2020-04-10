package com.example.restserviceproject.dao;

import com.example.restserviceproject.entity.Client;

import java.util.List;

public interface ClientDao {
    List<Client> findAll();

    Boolean insertClient(String fName, String lName, String sName);

    Boolean updateClient(Client client);

    Boolean deleteClient(Client client);


}
