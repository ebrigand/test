package com.astrelya.kata.bank.impl;

import com.astrelya.kata.bank.IBank;
import com.astrelya.kata.bank.IClient;

import java.math.BigDecimal;
import java.util.*;

public class KataBank implements IBank {

    private Map<String, IClient> clients = new HashMap<>();

    @Override
    public Collection<IClient> getClientList() {
        return clients.values();
    }

    @Override
    public void addClient(IClient client) {
        if(clients.containsKey(client.getEmail())){
            throw new IllegalArgumentException("Client " + client.getEmail() + " already exist");
        }
        clients.put(client.getEmail(), client);
    }

    @Override
    public Optional<IClient> searchClient(String email) {
        return Optional.ofNullable(clients.get(email));
    }

    @Override
    public BigDecimal getMonthlyPNL() {
        BigDecimal result = clients.values().stream().map(IClient::getMonthlyBalance)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return result.negate();

    }
}
