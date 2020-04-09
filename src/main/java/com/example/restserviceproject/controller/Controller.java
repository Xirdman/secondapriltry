package com.example.restserviceproject.controller;

import com.example.restserviceproject.entity.Client;
import com.example.restserviceproject.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class Controller {

    //@Resource
    private ClientService clientService;

    public Controller(@Autowired ClientService service) {
        this.clientService = service;
    }

    @GetMapping("/get")
    public List<Client> getClients() {
        return clientService.findAll();
    }

    @GetMapping("/delete")
    public void deleteClient(@RequestParam(value = "idOfClient") int idOfClient) {
        List<Client> list = clientService.findAll();
        Client client = findWithIterator(idOfClient, list);
        if (client != null) {
            clientService.deleteClient(client);
        }
    }

    @PostMapping("/add")
    public void addClient(@RequestParam(value = "clientId") int clientId,
                          @RequestParam(value = "clientFName")String fName,
                          @RequestParam(value = "clientLName")String lName,
                          @RequestParam(value = "clientSName")String sName) {
        clientService.insertClient(new Client(clientId,fName,lName,sName));
    }

    @PutMapping("/update")
    public void updateClient(@RequestParam(value = "client") Client client) {
        clientService.updateClient(client);
    }

    public Client findWithIterator(int id, List<Client> list) {
        Iterator<Client> iterator = list.iterator();
        while (iterator.hasNext()) {
            Client clientToCompare = iterator.next();
            if (clientToCompare.getId() == id) {
                return clientToCompare;
            }
        }
        return null;
    }

}
