package banking;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NetBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetBankApplication.class, args);
    }
//    public static void main(String[] args) {
//        BankAccount bankAccount1 = new BankAccount();
//        bankAccount1.setBalance(new BigDecimal(300));
//        BankAccount bankAccount2 = new BankAccount();
//        bankAccount2.setBalance(new BigDecimal(600));
//
//        TransactionService transactionService = new TransactionService();
//        System.out.println(bankAccount2.getBalance());
//        transactionService.withdraw(new BigDecimal(100),bankAccount2);
//        System.out.println(bankAccount2.getBalance());
//        transactionService.transfer(new BigDecimal(400),bankAccount2,bankAccount1);
//        System.out.println(bankAccount2.getBalance());
//        System.out.println(bankAccount1.getBalance());
//
//        AccountService accountService = new AccountService();
//        accountService.printTransactionHistory(bankAccount2);
//
//        for (Transaction transaction :
//                accountService.getTransactionsByTransactionType(bankAccount2, TransactionType.TRANSFER_OUT)) {
//            System.out.println(transaction);
//        }
//
//    }
}
