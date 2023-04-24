package com.example.moneytransfers.adapter.in.web;

import com.example.moneytransfers.application.port.in.SendMoneyCommand;
import com.example.moneytransfers.application.port.in.SendMoneyPort;
import com.example.moneytransfers.common.WebAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
public class MoneyTransferController {

    private final SendMoneyPort sendMoneyPort;

    public MoneyTransferController(SendMoneyPort sendMoneyPort) {
        this.sendMoneyPort = sendMoneyPort;
    }

    @PostMapping(path = "/accounts/transfer")
    void transfer(@RequestBody SendMoneyCommand command){
        sendMoneyPort.send(command);
    }
}
