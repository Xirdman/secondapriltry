package com.example.restserviceproject.service;

import com.example.restserviceproject.dao.ClientDao;
import com.example.restserviceproject.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    //@Resource
    ClientDao clientDao;

    public ClientServiceImpl(@Autowired ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public List<Client> findAll() {
        return clientDao.findAll();
    }

    @Override
    public void insertClient(String fName, String lName, String sName) {
        clientDao.insertClient(fName, lName, sName);
    }

    @Override
    public Boolean updateClient(Client client) {
        return clientDao.updateClient(client);

    }

    @Override
    public Boolean deleteClient(int id) {
        return clientDao.deleteClient(id);
    }

}
