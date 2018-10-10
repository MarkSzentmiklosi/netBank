package banking.model;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private static long nextId = 1;

    private long accountID;
    private BigDecimal balance;
    private List<Transaction> transactionHistory;

    {
        balance = BigDecimal.ZERO;
        transactionHistory = new ArrayList<Transaction>();
        accountID = nextId++;
    }

    public BankAccount() {
    }

    public long getAccountID() {
        return accountID;
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
