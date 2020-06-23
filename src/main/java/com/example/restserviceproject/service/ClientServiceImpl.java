package com.example.restserviceproject.service;

import com.example.restserviceproject.dao.ClientDao;
import com.example.restserviceproject.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    ClientDao clientDao;

    public ClientServiceImpl(@Autowired ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public Optional<List<Client>> findAll() {
        return clientDao.findAll();
    }

    @Override
    public int insertClient(String fName, String lName, String sName) {
        return clientDao.insertClient(fName, lName, sName);
    }

    @Override
    public Boolean updateClient(int id, String fName, String lName, String sName) {
        return clientDao.updateClient(id, fName, lName, sName);

    }

    @Override
    public Boolean deleteClient(int id) {
        return clientDao.deleteClient(id);
    }

    @Override
    public Optional<Client> findById(int id) {
        return clientDao.findByID(id);
    }

}
