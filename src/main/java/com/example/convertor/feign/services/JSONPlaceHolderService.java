package com.example.convertor.feign.services;

import java.util.List;

public interface JSONPlaceHolderService {
    List<Post> getPosts();
    Post getPostById(Long id);
}