package com.example.moneytransfers.adapter.out.persistence;

import com.example.moneytransfers.application.port.out.LoadAccountPort;
import com.example.moneytransfers.application.port.out.UpdateAccountPort;
import com.example.moneytransfers.common.PersistenceAdapter;
import com.example.moneytransfers.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;

@PersistenceAdapter
public class AccountPersistenceAdapter implements LoadAccountPort, UpdateAccountPort {

    @Autowired
    private SpringAccountRepository accountRepository;

   /* public AccountPersistenceAdapter(SpringAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
*/
    @Override
    public Account load(Long id) {
        return accountRepository
                .findById(id)
                .map(AccountMapper::entityToDomain)
                .orElseThrow(()-> new RuntimeException("No se pudo encontrar la cuenta solicitada"));
    }

    @Override
    public void update(Account account) {
        accountRepository.save(AccountMapper.domainToEntity(account));

    }
}
