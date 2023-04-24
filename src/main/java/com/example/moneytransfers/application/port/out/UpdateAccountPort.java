package com.example.moneytransfers.application.port.out;

import com.example.moneytransfers.adapter.out.persistence.SpringAccountRepository;
import com.example.moneytransfers.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;

public interface UpdateAccountPort {
    public void update(Account account);
}
