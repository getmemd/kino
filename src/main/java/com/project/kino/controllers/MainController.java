package com.project.kino.controllers;

import com.project.kino.entities.Users;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController extends BaseController {


    @GetMapping(path = "/")
    public String index(Model model) {
        return "index";
    }

    @PreAuthorize("isAnonymous()")
    @GetMapping(path = "/login")
    public String login(Model model) {
        return "annonymous/login";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping(path = "/profile")
    public String profile(Model model) {
        return "profile";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER')")
    @GetMapping(path = "/addpost")
    public String addPost(Model model) {
        return "user/addpost";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER')")
    @PostMapping(path = "/addpost")
    public String addPost(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "content") String content
    ) {
        Users currentUser = getUserData();
        return "redirect:/addpost?success";
    }

}
