package com.bank.app.service;

import com.bank.app.domain.Bank;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BankService {

    public abstract String getBankById(int id) throws JSONException;

    public abstract Bank getBankInfo(int id);

    public abstract boolean saveBank(Bank bank);

    public abstract void deleteBank(int bankId);

    public abstract List<Bank> getAllBanks();

}