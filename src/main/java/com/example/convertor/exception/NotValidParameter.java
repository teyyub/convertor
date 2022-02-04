package com.example.convertor.exception;

public class NotValidParameter extends RuntimeException{
    public NotValidParameter(String message){
        super(message);
    }
}
