package com.example.restserviceproject.controller;

import com.example.restserviceproject.entity.Client;
import org.springframework.dao.QueryTimeoutException;
import org.springframework.web.bind.annotation.*;
import com.example.restserviceproject.service.ClientService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class Controller {

    @Resource
    private ClientService clientService;

    @GetMapping("/get")
    public List<Client> getClients(){
        return clientService.findAll();
    }
    @DeleteMapping("/delete")
    public String deleteClient(@RequestParam(value = "idOfClient") int idOfClient){

            List<Client> list= clientService.findAll();/*
            Client client = list.get(idOfClient-1);
            clientService.deleteClient(client);*/
            Client client = findWithIterator(idOfClient,list);
            if (client!=null){
                clientService.deleteClient(client);
                return "Клиент с id = "+ idOfClient+ " удален";
            }
            return "ничего не получилось";//Тут надо отлавливать ошибку если клиент не может удалиться в БД из-за внешнего ключа?

    }
    @PostMapping("/add")
    public void addClient(@RequestParam(value = "client")Client client){
        clientService.insertClient(client);
    }

    @PutMapping("/update")
    public void updateClient(@RequestParam(value = "client")Client client){
        clientService.updateClient(client);
    }
    public Client findWithIterator(int id,List<Client> list){
        Iterator<Client> iterator= list.iterator();
        while (iterator.hasNext()){
            Client clientToCompare = iterator.next();
            if (clientToCompare.getId()==id){
                return clientToCompare;
            }
        }
        return null;
    }

}
