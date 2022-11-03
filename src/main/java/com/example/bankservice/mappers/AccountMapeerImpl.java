package com.example.bankservice.mappers;


import com.example.bankservice.dto.BankAccountResponseDTO;
import com.example.bankservice.entities.BankAcount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AccountMapeerImpl {

    public BankAccountResponseDTO fromBankAccount(BankAcount bankAcount){
        BankAccountResponseDTO bankAccountResponseDTO=new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAcount,bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }
}
