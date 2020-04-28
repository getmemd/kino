package com.project.kino.services.impl;

import com.project.kino.entities.Posts;
import com.project.kino.repositories.PostRepository;
import com.project.kino.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Posts addPost(Posts post) {
        return postRepository.save(post);
    }

    @Override
    public List<Posts> getAllPosts() {
        return postRepository.findAllByDeletedAtNullOrderByCreatedAtDesc();
    }

    @Override
    public Posts getPostById(Long id) {
        return postRepository.findByDeletedAtNullAndId(id);
    }
}
