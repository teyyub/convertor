package com.example.convertor.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

//@RestController
//@RequestMapping("/convertors")
public class Convertor {
    @GetMapping
    public ResponseEntity<?> result(@RequestParam(name = "amount") BigDecimal amount,
                                    @RequestParam(name = "source") String source ,
                                    @RequestParam(name = "target") String target){


        return ResponseEntity.ok(source + " - " + target);
    }

    @GetMapping("/v1")
    public ResponseEntity<?> resultV1(@RequestParam Map<String, String> params){
        return ResponseEntity.ok(params.entrySet());
    }

}
