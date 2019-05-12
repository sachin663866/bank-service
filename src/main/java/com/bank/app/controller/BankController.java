package com.bank.app.controller;

import com.bank.app.serviceImpl.BankServiceImpl;
import com.bank.app.domain.Bank;/*
import com.bank.app.util.Consumer;
import com.bank.app.util.Producer;*/
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {
    private static final Logger logger = LogManager.getLogger(BankController.class.getName());
    private static final String Topic = "test";

    @Autowired
    private BankServiceImpl bankServiceImpl;

  /*  @Autowired
    Producer producer;

    @Autowired
    Consumer consumer;*/

    @RequestMapping(value = "/getBankById/{bankId}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public String getBankById(@PathVariable Integer bankId) throws JSONException {
        return bankServiceImpl.getBankById(bankId);
    }

    @RequestMapping(value = "/getBankInfo/{bankId}", method = RequestMethod.GET)
    @ResponseBody
    public Bank getBranchInfo(@PathVariable Integer bankId) {
        Bank bank = bankServiceImpl.getBankInfo(bankId);
        return bank;
    }

    @RequestMapping(value = "/getAllBanks", method = RequestMethod.GET)
    public List<Bank> getAllBanks() {
        return bankServiceImpl.getAllBanks();
    }

    @RequestMapping(value = "/insertBank", method = RequestMethod.POST)
    public HttpStatus insertBank(@RequestBody Bank bank) {
        boolean hasBankInfo = bankServiceImpl.saveBank(bank);

        /*if (hasBankInfo) {
            producer.sendBank(bank);
        }*/

        return hasBankInfo ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }

    @RequestMapping(value = "/updateBank", method = RequestMethod.PUT)
    public HttpStatus updateBank(@RequestBody Bank bank) {
      //  consumer.receive(bank.toString());
        return bankServiceImpl.saveBank(bank) ? HttpStatus.LOCKED : HttpStatus.BAD_REQUEST;
    }

    @RequestMapping(value = "/deleteBankById/{bankId}", method = RequestMethod.DELETE)
    public HttpStatus deleteBank(@PathVariable Integer bankId) {
        bankServiceImpl.deleteBank(bankId);
        return HttpStatus.NO_CONTENT;
    }

}
