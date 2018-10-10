package banking.service;

import banking.model.BankAccount;

import java.math.BigDecimal;

public interface BasicTransactions {

    void deposit(BigDecimal amount, BankAccount account);

    void withdrawal(BigDecimal amount, BankAccount account);

    void transfer(BigDecimal amount, BankAccount FromAccount, BankAccount ToAccount);

}
