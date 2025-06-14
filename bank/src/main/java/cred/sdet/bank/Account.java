package cred.sdet.bank;

import cred.sdet.bank.exception.InvalidTransactionException;

public class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    Account(String accountnumber, String accountHolderName, double balance) {
        this.accountNumber = accountnumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new InvalidTransactionException("Amount deposited should be greater than zero.");
        }

        this.balance += amount;
    }

    public void withdraw(double amount) {
        if(amount <= 0 || amount > this.balance) {
            throw new InvalidTransactionException("Invalid amount withdrawl");
        }

        this.balance += amount;
    }

    public void transfer(Account toAccount, double amount) {
        if (toAccount == null) {
            throw new InvalidTransactionException("Invalid account to transfer to.");
        }
        if (amount <= 0 || amount > this.balance) {
            throw new InvalidTransactionException("Invalid amount for transfer.");
        }

        this.balance -= amount;
        toAccount.deposit(amount);
    }
}
