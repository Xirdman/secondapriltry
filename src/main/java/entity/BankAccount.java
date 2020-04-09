package entity;

public class BankAccount {
    private int id, ownerId;
    private String accountNumber;
    private double balance;

    public BankAccount() {
    }

    public BankAccount(int ownerId, String accountNumber, double balance) {
        this.ownerId = ownerId;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public BankAccount(int id, int ownerId, String accountNumber, double balance) {
        this.id = id;
        this.ownerId = ownerId;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
