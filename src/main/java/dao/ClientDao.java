package dao;

import entity.Client;
import java.util.List;

public interface ClientDao {
    List<Client> findAll();
    void insertClient(Client client);
    void updateClient(Client client);
    void deleteClient(Client client);
    void executeUpdateClient(Client client);
}
