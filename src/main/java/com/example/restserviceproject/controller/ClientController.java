package com.example.restserviceproject.controller;

import com.example.restserviceproject.entity.Client;
import com.example.restserviceproject.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private ClientService clientService;

    public ClientController(@Autowired ClientService service) {
        this.clientService = service;
    }

    @GetMapping("/get")
    public List<Client> getClients() {
        return clientService.findAll();
    }

    @GetMapping("/delete")
    public String deleteClient(@RequestParam(value = "idOfClient") int idOfClient) {
        List<Client> list = clientService.findAll();
        Client client = findWithIterator(idOfClient, list);
        if (client != null) {
            if (clientService.deleteClient(client)) {
                return "Клиент удален";
            }
        }
        return "Клиент с id " + idOfClient + " не может быть удален";
    }

    @GetMapping("/add")
    public void addClient(@RequestParam(value = "clientFName") String fName,
                          @RequestParam(value = "clientLName") String lName,
                          @RequestParam(value = "clientSName") String sName) {
        clientService.insertClient(fName, lName, sName);
    }

    @GetMapping("/update")
    public String updateClient(@RequestParam(value = "id") int id,
                               @RequestParam(value = "clientFName") String fName,
                               @RequestParam(value = "clientLName") String lName,
                               @RequestParam(value = "clientSName") String sName) {
        List<Client> list = clientService.findAll();
        Client client = findWithIterator(id, list);
        if (client != null) {
            client.setFirstName(fName);
            client.setLastName(lName);
            client.setSurName(sName);
            clientService.updateClient(client);
            return "Клиент с " + id + " обновлен";
        }
        return "Клиент с " + id + " не может быть обновлен";

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
