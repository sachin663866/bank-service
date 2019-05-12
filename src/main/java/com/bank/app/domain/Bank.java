package com.bank.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bank")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Bank {

    @Id
    private int bankId;

    private String name;

    @OneToMany(mappedBy = "bank", fetch = FetchType.EAGER, cascade = {CascadeType.ALL},
            targetEntity = Branch.class)
    private List<Branch> branchList;

    public Bank() {
        super();
    }


    public Bank(int bankId, String name, List<Branch> branchList) {
        super();
        this.bankId = bankId;
        this.name = name;
        this.branchList = branchList;
    }


    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //   @JsonIgnore
    public List<Branch> getBranchList() {
        return branchList;
    }


    public void setBranchList(List<Branch> branchList) {
        this.branchList = branchList;
    }


    @Override
    public String toString() {
        return "{" +
                "bankId=" + bankId + ", name=" + name + '}';
    }


}
