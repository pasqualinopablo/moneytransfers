package com.example.moneytransfers.adapter.out.persistence;

import com.example.moneytransfers.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SpringAccountRepository extends JpaRepository<AccountEntity,Long> {
}
