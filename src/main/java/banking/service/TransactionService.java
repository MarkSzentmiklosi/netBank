package banking.service;

import banking.model.BankAccount;
import banking.model.Transaction;
import banking.model.TransactionType;
import banking.repository.BankAccountRepository;
import banking.service.interfaces.BasicTransactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class TransactionService implements BasicTransactions {

    private BankAccountRepository bankAccountRepository;

    @Autowired
    public TransactionService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public void deposit(BigDecimal amount, BankAccount account) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Invalid amount");

        account.setBalance(account.getBalance().add(amount));
        addNewTransactionToHistory(account, TransactionType.DEPOSIT, amount);
    }

    public void withdraw(BigDecimal amount, BankAccount account) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Invalid amount");
        else if (isTransactionExceedsTheBalance(account,amount))
            throw new IllegalArgumentException("Transaction amount exceeds available balance");

        account.setBalance(account.getBalance().subtract(amount));
        addNewTransactionToHistory(account, TransactionType.WITHDRAWAL, amount);
    }

    public void transfer(BigDecimal amount, BankAccount senderAccount, BankAccount receiverAccount) {
        if (isTransactionExceedsTheBalance(senderAccount, amount))
            throw new IllegalArgumentException("Transaction amount exceeds available balance");

        senderAccount.setBalance(senderAccount.getBalance().subtract(amount));
        addNewTransactionToHistory(senderAccount,TransactionType.TRANSFER_OUT,amount);

        receiverAccount.setBalance(receiverAccount.getBalance().add(amount));
        addNewTransactionToHistory(receiverAccount,TransactionType.TRANSFER_IN,amount);
    }

    private void addNewTransactionToHistory(BankAccount account, TransactionType transactionType, BigDecimal amount) {
        List<Transaction> transactions = account.getTransactionHistory();
        transactions.add(new Transaction(transactionType, new Date(), amount, account.getBalance(),account));
        account.setTransactionHistory(transactions);
        bankAccountRepository.save(account);
    }

    private boolean isTransactionExceedsTheBalance(BankAccount account, BigDecimal amount) {
        return account.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) <= 0;
    }
}
