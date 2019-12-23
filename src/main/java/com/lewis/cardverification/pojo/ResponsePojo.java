package com.lewis.cardverification.pojo;

import java.util.Map;

public class ResponsePojo {

    private Map<String, Object> number;
    private String scheme;
    private String type;
    private String brand;
    private String prepaid;
    private Map<String, Object> country;
    private Bank bank;

    public Map<String, Object> getNumber() {
        return number;
    }

    public void setNumber(Map<String, Object> number) {
        this.number = number;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrepaid() {
        return prepaid;
    }

    public void setPrepaid(String prepaid) {
        this.prepaid = prepaid;
    }

    public Map<String, Object> getCountry() {
        return country;
    }

    public void setCountry(Map<String, Object> country) {
        this.country = country;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

}
