package com.project.kino.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping(value = "/")
    public String index(Model model){
        return "index";
    }

    @GetMapping(value = "/login-reg")
    public String login_reg(Model model){
        return "login-reg";
    }

    @GetMapping(value = "/featured")
    public String featured(Model model){
        return "featured1";
    }
}
