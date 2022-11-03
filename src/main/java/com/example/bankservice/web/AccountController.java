package com.example.bankservice.web;

import com.example.bankservice.dto.BankAccountRequestDTO;
import com.example.bankservice.dto.BankAccountResponseDTO;
import com.example.bankservice.entities.BankAcount;
import com.example.bankservice.repositories.BankAccountRepository;
import com.example.bankservice.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AccountController {
    AccountService accountService;
    BankAccountRepository bankAccountRepository;
    @GetMapping("/BankAccounts")
    public List<BankAcount> BankAccounts(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/BankAccounts/{id}")
    public BankAcount BankAccounts(@PathVariable String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("account %s Not found",id)));
    }
    @PostMapping("/BankAccounts")
    public BankAccountResponseDTO SaveBankAccount(@RequestBody BankAccountRequestDTO bankAccountRequestDTO){
        return accountService.addAccount(bankAccountRequestDTO);
    }
    @PutMapping("/BankAccounts/{id}")
    public BankAcount UpdateBankAccount(@PathVariable String id, @RequestBody BankAcount bankAcount){
        BankAcount account=bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
        if(bankAcount.getBalance()!=null) account.setBalance(bankAcount.getBalance());
        if(bankAcount.getCurrency()!=null) account.setCurrency(bankAcount.getCurrency());
        if(bankAcount.getCreatedDate()!=null) account.setCreatedDate(new Date());
        if(bankAcount.getType()!=null) account.setType(bankAcount.getType());
        return bankAccountRepository.save(account);
    }
    @DeleteMapping("/BankAccounts/{id}")
    public void DeleteBankAccounts(@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }


}
