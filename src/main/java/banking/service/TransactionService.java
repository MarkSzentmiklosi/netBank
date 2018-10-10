package banking.service;

import banking.model.BankAccount;
import banking.model.Transaction;
import banking.model.TransactionType;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TransactionService implements BasicTransactions {

    public void deposit(BigDecimal amount, BankAccount account) {

        if (amount.compareTo(BigDecimal.ZERO) == -1 || amount.compareTo(BigDecimal.ZERO) == 0)
            throw new IllegalArgumentException("Invalid amount");

        account.setBalance(account.getBalance().add(amount));
        List<Transaction> updatedTransactionHistory = addNewTransaction(account, TransactionType.DEPOSIT, amount);
        account.setTransactionHistory(updatedTransactionHistory);
    }

    public void withdrawal(BigDecimal amount, BankAccount account) {

    }

    public void transfer(BigDecimal amount, BankAccount FromAccount, BankAccount ToAccount) {

    }

    private List<Transaction> addNewTransaction(BankAccount account, TransactionType transactionType, BigDecimal amount) {
        List<Transaction> transactions = account.getTransactionHistory();
        transactions.add(new Transaction(transactionType, new Date(), amount, account.getBalance()));
        return transactions;
    }
}
