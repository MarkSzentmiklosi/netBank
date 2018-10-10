package banking.model;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
    private TransactionType transactionType;
    private Date dateOfTransaction;
    private BigDecimal amount;
    private BigDecimal balanceAfterTransaction;

    public Transaction(TransactionType transactionType, Date dateOfTransaction, BigDecimal amount, BigDecimal balanceAfterTransaction) {
        this.transactionType = transactionType;
        this.dateOfTransaction = dateOfTransaction;
        this.amount = amount;
        this.balanceAfterTransaction = balanceAfterTransaction;
    }
}
