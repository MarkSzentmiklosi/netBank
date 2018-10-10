package banking.model;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
    TransactionType transactionType;
    Date dateOfTransaction;
    BigDecimal amount;
    BigDecimal balanceAfterTransaction;
}
