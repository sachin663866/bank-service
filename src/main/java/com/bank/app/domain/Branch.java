
package com.bank.app.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.*;

@Entity
@Table(name = "branch")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Configuration
@ComponentScan
@ResponseBody
public class Branch {

    @Id
    private int branchCode;

    private String branchName;
    private String branchType;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Bank.class)
    @JoinColumn(name = "bank_id")
    @JsonBackReference
    private Bank bank;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    public Branch() {
    }

    public Branch(int branchCode, String branchName, String branchType, Bank bank, Address address) {
        super();
        this.branchCode = branchCode;
        this.branchName = branchName;
        this.branchType = branchType;
        this.bank = bank;
        this.address = address;
    }

    public int getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(int branchCode) {
        this.branchCode = branchCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public String setBranchName(String branchName) {
        return this.branchName = branchName;
    }

    public String getBranchType() {
        return branchType;
    }

    public void setBranchType(String branchType) {
        this.branchType = branchType;
    }

    public void setBranch(String branchType) {
        bank.getBankId();
    }


    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

   /* @Override
    public String toString() {
        return "Branch{" +
                "branchCode=" + branchCode +
                ", branchName='" + branchName + '\'' +
                ", branchType='" + branchType + '\'' +
                '}';
    }*/
}


