package com.example.convertor.config;


import com.example.convertor.feign.client.JSONRatesClient;
import com.example.convertor.feign.model.FooData;
import org.springframework.stereotype.Component;

@Component
public class JSONRatesFallback implements JSONRatesClient {

    @Override
    public FooData getRate() {
        return null;
    }

}