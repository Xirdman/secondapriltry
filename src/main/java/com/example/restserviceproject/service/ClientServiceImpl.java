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
    public void insertClient(Client client) {
        clientDao.insertClient(client);
    }

    @Override
    public void updateClient(Client client) {
        clientDao.updateClient(client);

    }

    @Override
    public void deleteClient(Client client) {
        clientDao.deleteClient(client);

    }

    @Override
    public void executeUpdateClient(Client client) {
        clientDao.executeUpdateClient(client);

    }
}
