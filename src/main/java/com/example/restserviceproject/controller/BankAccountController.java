package com.example.restserviceproject.controller;

import com.example.restserviceproject.entity.BankAccountDto;
import com.example.restserviceproject.entity.BankAccountListDto;
import com.example.restserviceproject.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bankaccounts")
public class BankAccountController {
    private BankAccountService bankAccountService;

    public BankAccountController(@Autowired BankAccountService service) {
        bankAccountService = service;
    }

    @GetMapping("/get")
    public List<BankAccountDto> findAll() throws Exception {
        return bankAccountService.findAll().map(BankAccountListDto::toDto).orElseThrow(()->new Exception("Bank accounts not founded"));
    }
}
