package com.example.restserviceproject.service;

import com.example.restserviceproject.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> findAll();

    void insertClient(String fName, String lName, String sName);

    Boolean updateClient(int id,String fName, String lName, String sName);

    Boolean deleteClient(int id);

    Optional<Client> findById(int id);
}
