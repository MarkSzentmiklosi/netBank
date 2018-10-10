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

    @Test
    void withdraw_ThrowsException_IfAmountIsEqualOrLessThanZero() {
        assertThrows(IllegalArgumentException.class, () -> transactionService.withdraw(new BigDecimal(-130), bankAccount));
    }

    @Test
    void withdraw_ThrowsException_IfAmountExceedsBalance() {
        assertThrows(IllegalArgumentException.class, () -> transactionService.withdraw(bankAccount.getBalance().add(new BigDecimal(200)), bankAccount));
    }

    @Test
    void withdraw_subctractsAmountFromBalance() {
        BigDecimal balanceBeforeTransaction = bankAccount.getBalance();
        BigDecimal amount = new BigDecimal(300.45123);
        transactionService.withdraw(amount, bankAccount);
        assertEquals(balanceBeforeTransaction.subtract(amount), bankAccount.getBalance());
    }
}