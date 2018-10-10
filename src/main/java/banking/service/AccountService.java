package banking.service;

import banking.model.BankAccount;
import banking.model.Transaction;
import banking.model.TransactionType;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class AccountService implements FilteringHistory{

    public void printTransactionHistory(BankAccount account){
        account.getTransactionHistory().stream()
                .forEach(System.out::println);
    }

    @Override
    public List<Transaction> getTransactionsByTransactionType(BankAccount account, TransactionType type) {
        return account.getTransactionHistory().stream()
                .filter(transaction -> transaction.getTransactionType().equals(type))
                .collect(Collectors.toList());
    }

    @Override
    public List<Transaction> getTransactionsByDate(BankAccount account, Date since, Date until) {
        return null;
    }
}
