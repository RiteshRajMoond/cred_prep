package cred.sdet.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cred.sdet.bank.exception.InvalidTransactionException;

public class BankTests {
    private Bank bank;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        bank.createAccount("12345", "John Doe", 1000.0);
    }

    @Test
    void testDeposit() {
        bank.deposit("12345", 500.0);
        Account account = bank.getAccountDetails("12345");
        assertEquals(1500.0, account.getBalance(), "Deposit should increase the balance correctly.");
    }

    @Test
    void testWithdraw() {
        bank.withdraw("12345", 500.0);
        Account account = bank.getAccountDetails("12345");
        assertEquals(500, account.getBalance(), "Withdraw should decrease the balance correctly.");
    }

    @Test
    void testInsufficientBalanceWithddraw() {
        assertThrows(InvalidTransactionException.class, () -> {
            bank.withdraw("12345", 99999);
        }, "Withdrawing more than alance should throw InvalidTransactionException");
    }

    @Test
    void testInvalidAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            bank.withdraw("12345", -100);
        }, "Amount should be greater than zero");
    }

    @Test
    void testTransfer() {
        bank.createAccount("98765", "Jason Grace", 0);

        Account fromAccount = bank.getAccountDetails("12345");
        Account toAccount = bank.getAccountDetails("98765");

        fromAccount.transfer(toAccount, 500.0);

        System.out.println(toAccount.getBalance());
        System.out.println(fromAccount.getBalance());
        assertEquals(500.0, toAccount.getBalance());
        assertEquals(500.0, fromAccount.getBalance());

    }
}
