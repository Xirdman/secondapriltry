package service;

import dao.ClientDao;
import entity.Client;

import javax.annotation.Resource;
import java.util.List;

public class ClientServiceImpl implements ClientService {
    @Resource
    ClientDao clientDao;
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
