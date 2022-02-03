package com.example.convertor.feign.services;

import com.example.convertor.feign.model.Post;

import java.util.List;

public interface JSONPlaceHolderService {

    List<Post> getPosts();

    Post getPostById(Long id);
}