package com.example.restserviceproject.controller;

import com.example.restserviceproject.entity.Client;
import com.example.restserviceproject.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    @DeleteMapping("/delete/{clientId}")
    public void deleteClient(@PathVariable int clientId) {
        if (!clientService.deleteClient(clientId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Client didnt finded");
        }
    }

    @PutMapping("/add")
    public void addClient(@RequestParam(value = "client") Client client) {
        clientService.insertClient(client.getFirstName(), client.getLastName(), client.getSurName());
    }

    @PutMapping("/update")
    public void updateClient(@RequestParam(value = "client") Client client){
        if( !clientService.updateClient(client.getId(),client.getFirstName(),client.getLastName(),client.getSurName())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Клиент не найден");
        }
    }

    @GetMapping ("/get/{id}")
    public Client getById(@PathVariable int id){
        Optional<Client> clientOptional = clientService.findById(id);
        if(clientOptional.isPresent()){
            return clientOptional.get();
        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Client dont find");
        }

    }
}
