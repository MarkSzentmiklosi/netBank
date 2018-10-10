package banking.model;

import org.hibernate.validator.internal.IgnoreForbiddenApisErrors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    private Date dateOfTransaction;
    private BigDecimal amount;
    private BigDecimal balanceAfterTransaction;
    @ManyToOne
    private BankAccount bankAccount;

    public Transaction(TransactionType transactionType, Date dateOfTransaction, BigDecimal amount, BigDecimal balanceAfterTransaction,BankAccount bankAccount) {
        this.transactionType = transactionType;
        this.dateOfTransaction = dateOfTransaction;
        this.amount = amount;
        this.balanceAfterTransaction = balanceAfterTransaction;
        this.bankAccount = bankAccount;
    }

    public Transaction() {
    }

    public long getId() {
        return id;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public Date getDateOfTransaction() {
        return dateOfTransaction;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getBalanceAfterTransaction() {
        return balanceAfterTransaction;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionType=" + transactionType +
                ", dateOfTransaction=" + dateOfTransaction +
                ", amount=" + amount +
                ", balanceAfterTransaction=" + balanceAfterTransaction +
                '}';
    }
}
