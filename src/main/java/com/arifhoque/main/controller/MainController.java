package com.arifhoque.main.controller;

import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/home")
    public String homePage(@RequestParam @Nullable String warning, Model model) {
        if (warning != null)
            model.addAttribute("warning","Incorrect username or password!");
        return "home-page.html";
    }

    @PostMapping("/dashboard")
    public String dashboard(HttpServletRequest request) {
        if (request.isUserInRole("ADMIN"))
            return "redirect:/admin";
        else
            return "redirect:/user";
    }

    @GetMapping("/user")
    public String userPage() {
        return "user-page.html";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin-page.html";
    }

}
