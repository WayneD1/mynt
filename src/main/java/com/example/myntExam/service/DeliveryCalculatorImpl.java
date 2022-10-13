package com.example.myntExam.service;

import com.example.myntExam.service.domain.Cost;
import com.example.myntExam.service.domain.Package;
import com.example.myntExam.service.domain.Voucher;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class DeliveryCalculatorImpl implements DeliveryCalculator {

    private final RestTemplate restTemplate;

    public DeliveryCalculatorImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public Cost calculate(Package packageToDeliver) {
        Voucher voucher = restTemplate.getForObject("https://mynt-exam.mocklab.io/voucher/MYNT?key=apikey", Voucher.class);
        return new Cost(packageToDeliver, voucher);
    }
}
