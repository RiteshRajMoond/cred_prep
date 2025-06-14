package cred.sdet.bank;

import java.time.LocalDateTime;
import java.util.List;

public class Transaction {
    private Account fromAccount;
    private Account toAccount;
    private double amount;
    private LocalDateTime timestamp;

    private List<Transaction> transactionHistory;

    public Transaction(Account fromAccount, Account toAccount, double amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public void addToTransactionHistory(Transaction transaction) {
        if (transactionHistory == null) {
            throw new IllegalStateException("Transaction history is not initialized.");
        }
        transactionHistory.add(transaction);
    }

}
