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

}
