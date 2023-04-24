package com.example.moneytransfers.domain;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class Account {
    private Long id;
    private BigDecimal amount;

    public Boolean isBalanceGreaterthan(BigDecimal anotherAmount){
        return this.amount.compareTo(anotherAmount) >= 0;
    }
    public void plus(BigDecimal amount){
        this.amount = this.amount.add(amount);
    }
    public void substract(BigDecimal amount){
        this.amount = this.amount.subtract(amount);
    }
}
