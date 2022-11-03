package com.example.bankservice.service;

import com.example.bankservice.dto.BankAccountRequestDTO;
import com.example.bankservice.dto.BankAccountResponseDTO;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO);

    public BankAccountResponseDTO updateAccount(String id,BankAccountRequestDTO bankAccountRequestDTO);
}
