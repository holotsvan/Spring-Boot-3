package com.luv2code.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String helloworld() {
        return "helloworld-form";
    }

    @PostMapping("/respondForm")
    public String helloResp(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name.toUpperCase(Locale.ROOT));
        return "hello-resp";
    }

    @RequestMapping("/tellEmail")
    public String tellEmail(HttpServletRequest request, Model model) {

        model.addAttribute("email", request.getParameter("email").toUpperCase(Locale.ROOT));
        return "hello-email-resp";
    }
}
