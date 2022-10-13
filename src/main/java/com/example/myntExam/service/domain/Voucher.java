package com.example.myntExam.service.domain;

import java.util.Date;

public class Voucher {

    private String code;
    private Double discount;
    private Date expiry;

    public Voucher() {
    }

    public Voucher(String code, Double discount, Date expiry) {
        this.code = code;
        this.discount = discount;
        this.expiry = expiry;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }
}
