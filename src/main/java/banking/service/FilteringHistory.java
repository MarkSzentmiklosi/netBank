package banking.service;

import banking.model.BankAccount;
import banking.model.Transaction;
import banking.model.TransactionType;

import java.util.Date;
import java.util.List;

public interface FilteringHistory {

    List<Transaction> getTransactionsByTransactionType(BankAccount account, TransactionType type);
    List<Transaction> getTransactionsByDate(BankAccount account, Date since, Date until);
}
