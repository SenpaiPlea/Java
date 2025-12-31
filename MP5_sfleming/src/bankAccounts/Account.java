package bankAccounts;

import java.time.LocalDate;

abstract class Account {
    private String accountNumber;
    private double balance;
    private final LocalDate dateCreated;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.dateCreated = LocalDate.now();
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

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public abstract void withdraw(double amount);
    public abstract void deposit(double amount);
}