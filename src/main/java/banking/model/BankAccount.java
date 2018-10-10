package banking.model;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankAccount<T> {

    private static long nextId = 1;

    long accountID;
    BigDecimal balance;
    List<Transaction> transactionHistory;

    {
        balance = BigDecimal.ZERO;
        transactionHistory = new ArrayList<Transaction>();
        accountID = nextId++;
    }

    public BankAccount() {
    }

    public static long getNextId() {
        return nextId;
    }

    public static void setNextId(long nextId) {
        BankAccount.nextId = nextId;
    }

    public long getAccountID() {
        return accountID;
    }

    public void setAccountID(long accountID) {
        this.accountID = accountID;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(List<Transaction> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }
}
