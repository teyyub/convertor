package com.example.convertor.controllers;


import com.example.convertor.services.ConvertorService;
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

    @GetMapping
    public ResponseEntity<?> result(@RequestParam(name = "amount") BigDecimal amount,
                                    @RequestParam(name = "source") String source ,
                                    @RequestParam(name = "target") String target){
        return service.convert(amount,source.toUpperCase(),target.toUpperCase());
    }

}
