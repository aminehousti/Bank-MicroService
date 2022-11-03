package com.example.bankservice.entities;


import com.example.bankservice.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAcount.class,name = "p1")
public interface AccountProjection {
   public String  getId();
   public AccountType getType();

}
