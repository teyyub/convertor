package com.example.convertor.feign.services;

import com.example.convertor.feign.model.RateData;

public interface RatesService {

    RateData getRate();
}