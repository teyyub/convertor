package com.example.convertor.feign.services;

import com.example.convertor.feign.client.JSONRatesClient;
import com.example.convertor.feign.model.RateData;
import org.springframework.stereotype.Service;

@Service
public class RatesServiceImpl implements RatesService {


    private final JSONRatesClient ratesClient;


    public RatesServiceImpl(JSONRatesClient ratesClient) {
        this.ratesClient = ratesClient;
    }

    @Override
    public RateData getRate() {
        return ratesClient.getRate();
    }
}