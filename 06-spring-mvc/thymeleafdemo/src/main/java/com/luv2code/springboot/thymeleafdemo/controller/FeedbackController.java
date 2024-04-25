package com.luv2code.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {

    @GetMapping("/form")
    public String showFeedbackForm() {
        return "feedbackForm";
    }

    @PostMapping("/submitFeedback")
    public String submitFeedback(@RequestParam("name") String name,
                                 @RequestParam("email") String email,
                                 @RequestParam("message") String message,
                                 Model model) {

        System.out.println("Received feedback:");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Message: " + message);

        model.addAttribute("name",name);

        return "thanksPage";
    }

}