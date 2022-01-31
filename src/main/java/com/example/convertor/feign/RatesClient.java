package com.example.convertor.feign;

import com.example.convertor.feign.model.RateResource;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface RatesClient {
    @RequestLine("GET /{isbn}")
    RateResource findByIsbn(@Param("isbn") String isbn);

//    @RequestLine("GET")
//    List<BookResource> findAll();

//    @RequestLine("POST")
//    @Headers("Content-Type: application/json")
//    void create(Book book);
}