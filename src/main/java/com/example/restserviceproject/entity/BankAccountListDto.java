package com.example.restserviceproject.entity;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BankAccountListDto {
    public static List<BankAccountDto> toDto(List<BankAccount> bankAccounts) {
        List<BankAccountDto> list = new LinkedList<>();
        Iterator<BankAccount> iterator = bankAccounts.iterator();
        while (iterator.hasNext()) {
            BankAccount bankAccount = iterator.next();
            list.add(BankAccountDto.toDto(bankAccount));
        }
        return list;
    }
}
