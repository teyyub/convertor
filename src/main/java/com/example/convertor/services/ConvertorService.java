package com.example.convertor.services;

import com.example.convertor.exception.NotValidParameter;
import com.example.convertor.feign.client.JSONRatesClient;
import com.example.convertor.feign.model.RateData;
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
        BigDecimal result =  new BigDecimal(0);
        RateData rateData = ratesClient.getRate();
        Map<String,BigDecimal> rates = rateData.getRates();
        BigDecimal sourceValue = rates.get(source);
        BigDecimal targetValue = rates.get(target);
        if(amount.compareTo(BigDecimal.ZERO)<0)
            throw  new NotValidParameter("Amount not valid");
        if(sourceValue ==null) throw  new NotValidParameter("Source value not valid");
        if(targetValue ==null) throw  new NotValidParameter("Target value not valid");
        if (!amount.equals(BigDecimal.ZERO)){
            result =  amount.multiply(targetValue.divide(sourceValue,8, RoundingMode.CEILING));
        }
        return ResponseEntity.ok(result);
    }
    public ResponseEntity<?> availableRate(){
      return  ResponseEntity.ok(ratesClient.getRate().getRates().keySet()) ;
    }
}
