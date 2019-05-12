package com.bank.app.serviceImpl;

import com.bank.app.domain.Bank;
import com.bank.app.repository.BankRepository;
import com.bank.app.repository.BranchRepository;
import com.bank.app.service.BankService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository bankRepo;

    @SuppressWarnings("unused")
    @Autowired
    private BranchRepository branchRepository;

    @Transactional
    public Bank getBankInfo(int bankId) {
        Bank bank = bankRepo.getOne(bankId);
        return bank;
    }

    @Transactional
    public String getBankById(int bankId) throws JSONException {
        String str = bankRepo.getOne(bankId).toString();
        JsonParser jsonParser = new JsonParser();
        JsonObject objectFromString = jsonParser.parse(str).getAsJsonObject();
        System.out.println("BankDetails---->" + objectFromString);
        return String.valueOf(objectFromString);
    }

    @Transactional
    public boolean saveBank(Bank bank) {
        return bankRepo.save(bank) != null;
    }

    @Transactional
    public void deleteBank(int bankId) {
        bankRepo.deleteById(bankId);
    }

    @Transactional
    public List<Bank> getAllBanks() {
        return (List<Bank>) bankRepo.findAll();
    }

}
