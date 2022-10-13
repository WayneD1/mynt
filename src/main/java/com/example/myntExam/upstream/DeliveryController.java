package com.example.myntExam.upstream;

import com.example.myntExam.service.DeliveryCalculator;
import com.example.myntExam.service.domain.Cost;
import com.example.myntExam.service.domain.Package;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.function.Function;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryCalculator deliveryCalculator;


    @PostMapping("/calculate")
    public ResponseEntity<CostResponse> calculateTheCost(@RequestBody PackageRequest packageRequest) {

        return ResponseEntity
                .ok(costDomainToCostResponseAdapter
                        .apply(deliveryCalculator.calculate(
                                packageRequestToPackageDomainAdapter
                                        .apply(packageRequest))));
    }


    private Function<PackageRequest, Package> packageRequestToPackageDomainAdapter = (request) ->
            new Package(request.getWeight(), request.getHeight(), request.getWidth(), request.getLength(), request.getVoucherCode()
            );


    private Function<Cost, CostResponse> costDomainToCostResponseAdapter = (domain) ->
            new CostResponse(domain.getPriority(), domain.getRuleName(), domain.getCost());
}
