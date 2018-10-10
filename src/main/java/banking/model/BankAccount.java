package banking.model;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankAccount<T> {
    BigDecimal balance;
    List<Transaction> transactionHistory;
    {
        balance = BigDecimal.ZERO;
        transactionHistory = new ArrayList<Transaction>();
    }
}
