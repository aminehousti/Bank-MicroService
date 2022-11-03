package com.example.bankservice.web;

import com.example.bankservice.dto.BankAccountRequestDTO;
import com.example.bankservice.dto.BankAccountResponseDTO;
import com.example.bankservice.entities.BankAcount;
import com.example.bankservice.repositories.BankAccountRepository;
import com.example.bankservice.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller @AllArgsConstructor
public class AccountGraphQlController {
    BankAccountRepository bankAccountRepository;
    AccountService accountService;
    @QueryMapping
    public List<BankAcount> accountLists(){

        return bankAccountRepository.findAll();
    }
    @QueryMapping
    public BankAcount accountByID(@Argument String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("compte %s non trouvé",id)));
    }
    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO BankAcount){
        return accountService.addAccount(BankAcount);
    }
    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id,@Argument BankAccountRequestDTO BankAcount){
        return accountService.updateAccount(id,BankAcount);
    }
    @MutationMapping
    public void DeleteAccount(@Argument String id){
       bankAccountRepository.deleteById(id);

    }

}
