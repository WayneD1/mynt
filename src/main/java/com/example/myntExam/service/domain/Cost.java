package com.example.myntExam.service.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Cost {

    private final Package packageBeingCalculated;
    private int priority;
    private String ruleName;
    private BigDecimal cost;


    public Cost(Package packageBeingCalculated) {
        this.packageBeingCalculated = packageBeingCalculated;
        initializeCosting(null);
    }

    public Cost(Package packageBeingCalculated, Voucher voucher) {
        this.packageBeingCalculated = packageBeingCalculated;
        initializeCosting(voucher);
    }

    public void initializeCosting(Voucher voucher) {

        BigDecimal discount = voucher.getExpiry().after(new Date()) ? BigDecimal
                .valueOf(voucher.getDiscount()).divide(BigDecimal.valueOf(100)) : BigDecimal.valueOf(0);

        if (packageBeingCalculated.getWeight() > 50) {
            priority = 1;
            ruleName = "Reject";
            cost = BigDecimal.ZERO;
        } else if (packageBeingCalculated.getWeight() > 10) {
            priority = 2;
            ruleName = "Heavy Parcel";
            BigDecimal originalCost = BigDecimal.valueOf(20).multiply(BigDecimal.valueOf(packageBeingCalculated.getWeight()));
            cost = originalCost.subtract(originalCost.multiply(discount));
        } else if (packageBeingCalculated.calculateVolume() < 1500) {
            priority = 3;
            ruleName = "Small Parcel";
            BigDecimal originalCost = BigDecimal.valueOf(0.03).multiply(BigDecimal.valueOf(packageBeingCalculated.calculateVolume()));
            cost = originalCost.subtract(originalCost.multiply(discount));
        } else if (packageBeingCalculated.calculateVolume() < 2500) {
            priority = 4;
            ruleName = "Medium Parcel";
            BigDecimal originalCost = BigDecimal.valueOf(0.04).multiply(BigDecimal.valueOf(packageBeingCalculated.calculateVolume()));
            cost = originalCost.subtract(originalCost.multiply(discount));
        } else {
            priority = 5;
            ruleName = "Large Parcel";
            BigDecimal originalCost = BigDecimal.valueOf(0.05).multiply(BigDecimal.valueOf(packageBeingCalculated.calculateVolume()));
            cost = originalCost.subtract(originalCost.multiply(discount));
        }
    }

    public int getPriority() {
        return priority;
    }

    public String getRuleName() {
        return ruleName;
    }

    public BigDecimal getCost() {
        return cost;
    }


}
