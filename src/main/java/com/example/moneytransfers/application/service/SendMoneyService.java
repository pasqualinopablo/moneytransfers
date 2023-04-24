package com.example.moneytransfers.application.service;

import com.example.moneytransfers.application.port.in.SendMoneyCommand;
import com.example.moneytransfers.application.port.in.SendMoneyPort;
import com.example.moneytransfers.application.port.out.LoadAccountPort;
import com.example.moneytransfers.application.port.out.UpdateAccountPort;
import com.example.moneytransfers.common.UseCase;
import com.example.moneytransfers.domain.Account;
import jakarta.transaction.Transactional;

@UseCase
public class SendMoneyService implements SendMoneyPort {
    private final LoadAccountPort loadAccountPort;
    private final UpdateAccountPort updateAccountPort;

    public SendMoneyService(LoadAccountPort loadAccountPort, UpdateAccountPort updateAccountPort) {
        this.loadAccountPort = loadAccountPort;
        this.updateAccountPort = updateAccountPort;
    }

    @Transactional
    @Override
    public boolean send(SendMoneyCommand command) {

        Account source = loadAccountPort.load(command.getSourceId());
        Account target = loadAccountPort.load(command.getTargetId());

        if(!source.isBalanceGreaterthan(command.getAmount())){
            throw new RuntimeException("source account noy have enough balance amount...");
        }

        target.plus(command.getAmount());
        source.substract(command.getAmount());

        updateAccountPort.update(source);
        updateAccountPort.update(target);

        return true;
    }
}
