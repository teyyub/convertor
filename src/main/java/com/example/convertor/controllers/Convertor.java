package com.example.convertor.controllers;


import com.example.convertor.exception.NotValidParameter;
import com.example.convertor.feign.client.JSONRatesClient;
import com.example.convertor.feign.model.FooData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@RestController
@RequestMapping("/convertors")
public class Convertor {
    private final JSONRatesClient ratesClient;

    public Convertor(JSONRatesClient ratesClient) {
        this.ratesClient = ratesClient;
    }

    @GetMapping
    public ResponseEntity<?> result(@RequestParam(name = "amount") BigDecimal amount,
                                    @RequestParam(name = "source") String source ,
                                    @RequestParam(name = "target") String target){
        return convert(amount,source.toUpperCase(),target.toUpperCase());
    }
    private ResponseEntity<?>convert(BigDecimal amount , String source, String target){
        FooData fooData = ratesClient.getRate();
        Map<String,BigDecimal> rates = fooData.getRates();
        BigDecimal sourceValue = rates.get(source);
        BigDecimal targetValue = rates.get(target);
        if(amount.compareTo(BigDecimal.ZERO)<0)
            throw  new NotValidParameter("Amount not valid");
        if(sourceValue ==null) throw  new NotValidParameter("Source value not valid");
        if(target ==null) throw  new NotValidParameter("Target value not valid");

        BigDecimal result =  amount.multiply(targetValue.divide(sourceValue,8, RoundingMode.CEILING));
        return ResponseEntity.ok(result);
    }
}
