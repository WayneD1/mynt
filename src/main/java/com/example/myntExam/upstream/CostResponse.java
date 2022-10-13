package com.example.myntExam.upstream;

import java.math.BigDecimal;

public class CostResponse {

    private int priority;
    private String ruleName;
    private BigDecimal cost;

    public CostResponse() {
    }

    public CostResponse(int priority, String ruleName, BigDecimal cost) {
        this.priority = priority;
        this.ruleName = ruleName;
        this.cost = cost;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
