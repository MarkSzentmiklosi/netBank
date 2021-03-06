package banking.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountID;
    private BigDecimal balance;
    @OneToMany(mappedBy = "bankAccount")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Transaction> transactionHistory;

    {
        balance = BigDecimal.ZERO;
        transactionHistory = new ArrayList<Transaction>();
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
