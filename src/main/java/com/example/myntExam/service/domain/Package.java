package com.example.myntExam.service.domain;

public class Package {

    private Double weight;
    private Double height;
    private Double width;
    private Double length;
    private String voucherCode;

    public Package() {
    }

    public Package(Double weight, Double height, Double width, Double length, String voucherCode) {
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.length = length;
        this.voucherCode = voucherCode;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double calculateVolume() {
        return height * length * width;
    }

}
