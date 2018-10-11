package banking;


import banking.model.BankAccount;
import banking.repository.BankAccountRepository;
import banking.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class NetBankApplication {

    private BankAccountRepository bankAccountRepository;
    private TransactionService transactionService;

    public static void main(String[] args) {
        SpringApplication.run(NetBankApplication.class, args);
    }

    @Autowired
    public NetBankApplication(BankAccountRepository bankAccountRepository, TransactionService transactionService) {
        this.bankAccountRepository = bankAccountRepository;
        this.transactionService = transactionService;
    }

    @Bean
    public CommandLineRunner loadData() {
        return (args) -> {
            BankAccount bankAccount1 = new BankAccount();
            bankAccount1.setBalance(new BigDecimal(300));
            BankAccount bankAccount2 = new BankAccount();
            bankAccount2.setBalance(new BigDecimal(600));

            bankAccountRepository.save(bankAccount1);
            bankAccountRepository.save(bankAccount2);

            transactionService.deposit(new BigDecimal(200), bankAccount2);


        };
    }
}
