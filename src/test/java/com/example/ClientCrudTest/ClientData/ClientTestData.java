package com.example.ClientCrudTest.ClientData;

import com.example.restserviceproject.entity.Client;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
public class ClientTestData {
    private List<Client> listOfClients;

    public List<Client> getListOfClients() {
        return listOfClients;
    }
    public ClientTestData() {
        listOfClients.add(new Client(222,"testClient222","testCl222","No"));
        listOfClients.add(new Client(223,"testClient223","testCl222","No"));
        listOfClients.add(new Client(224,"testClient224","testCl222","No"));
        listOfClients.add(new Client(225,"testClient225","testCl222","No"));
        listOfClients.add(new Client(226,"testClient226","testCl222","No"));
    }
}
