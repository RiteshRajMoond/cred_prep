package cred.sdet.bank;

import java.util.HashMap;

public class Bank {
    private HashMap<String, Account> accounts = new HashMap<>();

    public void createAccount(String accountNumber, String accountHolderName, double initialBalance) {
        if (accounts.containsKey(accountNumber)) {
            throw new IllegalArgumentException("Account with this number already exists.");
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }

        Account newAccount = new Account(accountNumber, accountHolderName, initialBalance);
        accounts.put(accountNumber, newAccount);
    }

    public void getAccountDetails(String accountNumber) {
        if (!accounts.containsKey(accountNumber))
            throw new IllegalArgumentException(
                    "Account with this number does not exist.");

        Account account = accounts.get(accountNumber);
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Holder Name: " + account.getAccountHolderName());
        System.out.println("Balance: " + account.getBalance());
    }

    public void printAllDocs() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        for (Account account : accounts.values()) {
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Holder Name: " + account.getAccountHolderName());
            System.out.println("Balance: " + account.getBalance());
            System.out.println("-----------------------------");
        }
    }
}
