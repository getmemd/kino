package com.project.kino.controllers;

import com.project.kino.entities.Posts;
import com.project.kino.entities.Users;
import com.project.kino.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class MainController extends BaseController{

    @Autowired
    private PostService postService;

    @GetMapping(path = "/")
    public String index(Model model){
        List<Posts> allPosts = postService.getAllPosts();
        model.addAttribute("posts", allPosts);
        return "index";
    }

    @PreAuthorize("isAnonymous()")
    @GetMapping(path = "/login")
    public String login(Model model){
        return "annonymous/login";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping(path = "/profile")
    public String profile(Model model){
        return "profile";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER')")
    @GetMapping(path = "/addpost")
    public String addPost(Model model){
        return "user/addpost";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER')")
    @PostMapping(path = "/addpost")
    public String addPost(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "content") String content
    ){
        Users currentUser = getUserData();
        Posts post = new Posts(currentUser, title, content);
        post.setCreatedAt(new Date());
        postService.addPost(post);
        return "redirect:/addpost?success";
    }

}
