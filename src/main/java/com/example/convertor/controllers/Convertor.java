package com.example.convertor.controllers;

import com.example.convertor.feign.RatesClient;
import feign.Feign;
import okhttp3.OkHttpClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/convertors")
public class Convertor {
    @GetMapping
    public ResponseEntity<?> result(@RequestParam(name = "source") String source , @RequestParam(name = "target") String target){

        RatesClient ratesClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
//                .logger(new Slf4jLogger(RatesClient.class))
//                .logLevel(Logger.Level.FULL)
                .target(RatesClient.class, "http://localhost:8081/api/books");

        return ResponseEntity.ok(source + " - " + target);
    }

}
