package com.bank.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    private int addressId;

    private String address1;
    private String address2;
    private String state;
    private String city;
    private String pin;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
    private Branch branch;

    public Address() {
        super();
    }

    public Address(int addressId, String address1, String address2, String state, String city, String pin,
                   Branch branch) {
        super();
        this.addressId = addressId;
        this.address1 = address1;
        this.address2 = address2;
        this.state = state;
        this.city = city;
        this.pin = pin;
        this.branch = branch;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @JsonIgnore
    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    /*@Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", pin='" + pin + '\'' +
                '}';
    }*/
}
