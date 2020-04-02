package service;

import entity.Client;

import java.util.List;

public interface ClientService {
    List<Client> findAll();
    void insertClient(Client client);
    void updateClient(Client client);
    void deleteClient(Client client);
    void executeUpdateClient(Client client);
}
