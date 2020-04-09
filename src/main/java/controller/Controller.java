package controller;

import entity.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ClientService;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class Controller {

    @Resource
    ClientService clientService;

    @GetMapping("/getClients")
    public List<Client> getClients(){
        return clientService.findAll();
    }

    @GetMapping("/test")
    public String test(){
        return "Тест";
    }
}
