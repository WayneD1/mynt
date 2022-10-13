package com.example.myntExam.service;

import com.example.myntExam.service.domain.Cost;
import com.example.myntExam.service.domain.Package;

import java.math.BigDecimal;

public interface DeliveryCalculator {

    Cost calculate(Package packageToDeliver);

}
