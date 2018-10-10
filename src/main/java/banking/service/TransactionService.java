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
        List<Transaction> updatedTransactionHistory = addNewTransactionToHistory(account, TransactionType.DEPOSIT, amount);
        account.setTransactionHistory(updatedTransactionHistory);
    }

    public void withdraw(BigDecimal amount, BankAccount account) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Invalid amount");
        else if (isTransactionExceedsTheBalance(account,amount))
            throw new IllegalArgumentException("Transaction amount exceeds available balance");

        account.setBalance(account.getBalance().subtract(amount));
        List<Transaction> updatedTransactionHistory = addNewTransactionToHistory(account, TransactionType.WITHDRAWAL, amount);
        account.setTransactionHistory(updatedTransactionHistory);
    }

    public void transfer(BigDecimal amount, BankAccount senderAccount, BankAccount receiverAccount) {
        if (isTransactionExceedsTheBalance(senderAccount, amount))
            throw new IllegalArgumentException("Transaction amount exceeds available balance");

        senderAccount.setBalance(senderAccount.getBalance().subtract(amount));
        addNewTransactionToHistory(senderAccount,TransactionType.TRANSFER,amount);

        receiverAccount.setBalance(receiverAccount.getBalance().add(amount));
        addNewTransactionToHistory(receiverAccount,TransactionType.TRANSFER,amount);
    }

    private List<Transaction> addNewTransactionToHistory(BankAccount account, TransactionType transactionType, BigDecimal amount) {
        List<Transaction> transactions = account.getTransactionHistory();
        transactions.add(new Transaction(transactionType, new Date(), amount, account.getBalance()));
        return transactions;
    }

    private boolean isTransactionExceedsTheBalance(BankAccount account, BigDecimal amount) {
        return account.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) <= 0;
    }
}
