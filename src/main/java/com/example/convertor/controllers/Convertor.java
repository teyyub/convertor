package com.example.convertor.controllers;


import com.example.convertor.services.ConvertorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/convertors")
public class Convertor {
    private final ConvertorService service;

    public Convertor(ConvertorService service) {
        this.service = service;
    }


    @Operation(summary = "API Description", description = "\"API which receives three inputs:\n" +
            "    A source currency" +
            "    A target currency " +
            "    A monetary value. For example source AZN target TRY amount 20")
    @GetMapping
    public ResponseEntity<?> result(@RequestParam(name = "amount") BigDecimal amount,
                                    @RequestParam(name = "source") String source ,
                                    @RequestParam(name = "target") String target){
        return service.convert(amount,source.toUpperCase(),target.toUpperCase());
    }

}
