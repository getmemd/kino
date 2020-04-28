package com.project.kino.services;


import com.project.kino.entities.Posts;

import java.util.List;

public interface PostService {

    Posts addPost(Posts post);

    List<Posts> getAllPosts();

    Posts getPostById(Long id);

}
