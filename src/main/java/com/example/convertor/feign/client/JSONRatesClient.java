package com.example.convertor.feign.client;

import com.example.convertor.config.ClientConfiguration;
import com.example.convertor.config.JSONRatesFallback;
import com.example.convertor.feign.model.FooData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(value = "jsonRates", url = "http://api.exchangeratesapi.io/v1/latest?access_key=404ecbb103d18acbe894afc6fee0f3e8",
        configuration = ClientConfiguration.class,
        fallback = JSONRatesFallback.class)
public interface JSONRatesClient {

    @GetMapping
    FooData getRate();

}