package com.example.ClientCrudTest;

import com.example.restserviceproject.controller.Controller;
import com.example.restserviceproject.entity.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ClientControllerTest {
    private Controller controller;
    private Client client;
    @Test
    public void contextLoads()  throws Exception{    }

    public ClientControllerTest(@Autowired Controller testController){
        controller = testController;
    }
    /*@Test
    public void TestMethod(){
        ClientTestData testData = new ClientTestData();
        List<Client> list = testData.getListOfClients();
    }*/
    @Test
    public void TestAddClient(){
        Client addedClient = new Client(1111,"testClient","testCl","YES");
        controller.addClient(addedClient);
        this.client = addedClient;
    }
    /*@Test
    public void updateClient(){
        client.setFirstName("updatedName");
        controller.updateClient(client);
    }*/
    @Test
    public void TestDeleteClient(){
        controller.deleteClient(1111);
    }


}
