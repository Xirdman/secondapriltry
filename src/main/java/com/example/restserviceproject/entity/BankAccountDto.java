package com.example.restserviceproject.entity;

public class BankAccountDto {
    private int ownerId;
    private double money;
    private String accountnumber;

    public int getOwnerId() {
        return ownerId;
    }

    public double getMoney() {
        return money;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public BankAccountDto(int ownerId, double money, String accountnumber) {
        this.ownerId = ownerId;
        this.money = money;
        this.accountnumber = accountnumber;
    }
    public static BankAccountDto toDto(BankAccount bankAccount){
        return new BankAccountDto(
                bankAccount.getOwnerId(),
                bankAccount.getBalance(),
                bankAccount.getAccountNumber());
    }
}
