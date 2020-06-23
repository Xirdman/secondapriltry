package com.example.restserviceproject.entity;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ClientListDto {
    public static List<ClientDto> toDto(List<Client> list){
        List<ClientDto> result = new LinkedList<>();
        Iterator<Client> iterator = list.iterator();
        while (iterator.hasNext()){
            Client client = iterator.next();
            result.add(ClientDto.toDto(client));
        }
        return result;
    }
}
