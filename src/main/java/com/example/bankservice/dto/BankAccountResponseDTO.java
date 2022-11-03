package com.example.bankservice.dto;

import com.example.bankservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;


@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccountResponseDTO {

    private String id;
    private Date createdDate;
    private Double balance;
    private String currency;
    private AccountType type;
}
