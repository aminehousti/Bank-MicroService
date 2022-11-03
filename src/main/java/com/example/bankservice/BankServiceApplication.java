package com.example.bankservice;

import com.example.bankservice.entities.BankAcount;
import com.example.bankservice.enums.AccountType;
import com.example.bankservice.repositories.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
@AllArgsConstructor
public class BankServiceApplication {

    BankAccountRepository bankAccountRepository;
    public static void main(String[] args) {
        SpringApplication.run(BankServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(){
        return args -> {
            for(int i=0;i<3;i++){
                BankAcount b=BankAcount.builder()
                        .id(UUID.randomUUID().toString())
                        .balance(20000.0)
                        .createdDate(new Date())
                        .type(Math.random()>0.5? AccountType.CurrentAccount:AccountType.SavingAccount)
                        .currency("dh")
                        .build();
                bankAccountRepository.save(b);

            }
        };
    }

}
