package com.example.convertor.services;

import com.example.convertor.exception.NotValidParameter;
import com.example.convertor.feign.client.JSONRatesClient;
import com.example.convertor.feign.model.FooData;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

@Service
public class ConvertorService {
    private final JSONRatesClient ratesClient;

    public ConvertorService(JSONRatesClient ratesClient) {
        this.ratesClient = ratesClient;
    }

    public ResponseEntity<?> convert(BigDecimal amount , String source, String target){
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
