package com.example.convertor.feign.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Data
public class FooData {
    private boolean success;
    private String base;
    @JsonIgnore
    private LocalDateTime timestamp;
    @JsonIgnore
    private String date;
    Map<String, BigDecimal> rates;
}
