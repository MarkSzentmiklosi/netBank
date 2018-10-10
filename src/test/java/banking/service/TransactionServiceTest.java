package banking.service;

import banking.model.BankAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {

    private BankAccount bankAccount;
    private TransactionService transactionService = new TransactionService();

    @BeforeEach
    void setup() {
        bankAccount = new BankAccount();
        bankAccount.setBalance(new BigDecimal(500));
    }

    @Test
    void deposit_ThrowsException_IfAmountIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> transactionService.deposit(new BigDecimal(0), bankAccount));
    }

    @Test
    void deposit_AddsAmountToBalance() {
        BigDecimal balanceBeforeTransaction = bankAccount.getBalance();
        BigDecimal transactionAmount = new BigDecimal(200);
        transactionService.deposit(transactionAmount, bankAccount);
        assertEquals(balanceBeforeTransaction.add(transactionAmount), bankAccount.getBalance());
    }
}