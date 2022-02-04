package com.example.convertor.feign.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JSONPlaceHolderServiceImpl implements JSONPlaceHolderService {


    private final JSONPlaceHolderClient jsonPlaceHolderClient;

    public JSONPlaceHolderServiceImpl(JSONPlaceHolderClient jsonPlaceHolderClient) {
        this.jsonPlaceHolderClient = jsonPlaceHolderClient;
    }

    @Override
    public List<Post> getPosts() {
        return jsonPlaceHolderClient.getPosts();
    }

    @Override
    public Post getPostById(Long id) {
        return jsonPlaceHolderClient.getPostById(id);
    }
}