package com.example.acid;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;


@Data
@Entity
@Table(name = "accounts")
class Account {
    @Id
    private String number;
    private double balance;
}

@Repository
interface AccountRepository extends JpaRepository<Account, String> {
}

@Service
class TransferService {

    @PersistenceContext
    EntityManager entityManager;

    private AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional(
            transactionManager = "transactionManager",
            isolation = Isolation.SERIALIZABLE
    )
    public void transfer(String from, String to, double amount) {
        Account fromAccount = accountRepository.findById(from).get();
        Account toAccount = accountRepository.findById(to).get();
        System.out.println(Thread.currentThread().getName() + " - From Account balance: " + fromAccount.getBalance());

        if (fromAccount.getBalance() < amount)
            throw new RuntimeException("Insufficient balance");

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
        entityManager.flush(); // Flush the changes to the database , update the database
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(false)
            throw new RuntimeException("Rollback transaction");
        System.out.println(Thread.currentThread().getName() + " - committed transaction");
    }

    @Transactional(
            transactionManager = "transactionManager",
//            isolation = Isolation.READ_UNCOMMITTED
//            isolation = Isolation.READ_COMMITTED  // default
            isolation = Isolation.SERIALIZABLE
    )
    public void getBalance(String accountNumber) {
        System.out.println(Thread.currentThread().getName() + " - Account balance: " + accountRepository.findById(accountNumber).get().getBalance());
    }

}

@SpringBootApplication
public class AcidApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AcidApplication.class, args);
    }

    @Autowired
    private TransferService transferService;

    @Override
    public void run(String... args) throws Exception {

        Thread t1 = new Thread(() -> {
            transferService.transfer("1234-5", "1234-6", 500);
        }, "transfer-thread");

        Thread t2 = new Thread(() -> {
            transferService.getBalance("1234-5");
        }, "balance-thread");

        t1.start();
        TimeUnit.SECONDS.sleep(5);
        t2.start();

    }
}
