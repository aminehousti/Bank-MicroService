package com.example.bankservice.service;

import com.example.bankservice.dto.BankAccountRequestDTO;
import com.example.bankservice.dto.BankAccountResponseDTO;
import com.example.bankservice.entities.BankAcount;
import com.example.bankservice.mappers.AccountMapeerImpl;
import com.example.bankservice.repositories.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;


@Service
@Transactional @AllArgsConstructor
public class AccountServiceImpl implements AccountService{
    AccountMapeerImpl mapper;
    BankAccountRepository bankAccountRepository;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAcount bankAcount=BankAcount.builder()
                .id(UUID.randomUUID().toString())
                .currency(bankAccountRequestDTO.getCurrency())
                .type(bankAccountRequestDTO.getType())
                .createdDate(new Date())
                .balance(bankAccountRequestDTO.getBalance())
                .build();
        BankAcount bankAcountSaved=bankAccountRepository.save(bankAcount);
        return mapper.fromBankAccount(bankAcountSaved);
    }

    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountRequestDTO) {
        BankAcount bankAcount=BankAcount.builder()
                .id(id)
                .currency(bankAccountRequestDTO.getCurrency())
                .type(bankAccountRequestDTO.getType())
                .createdDate(new Date())
                .balance(bankAccountRequestDTO.getBalance())
                .build();
        BankAcount bankAcountSaved=bankAccountRepository.save(bankAcount);
        return mapper.fromBankAccount(bankAcountSaved);
    }
}
