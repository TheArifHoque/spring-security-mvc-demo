package com.arifhoque.main.controller;

import jakarta.annotation.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

    @GetMapping("/home")
    public String homePage(@RequestParam @Nullable String isloginfailed) {
        return "home-page.html";
    }

    @RequestMapping("/user")
    public String userPage() {
        return "user-page.html";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin-page.html";
    }

}
