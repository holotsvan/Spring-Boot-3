package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class SignUpController {

    // take countries from application.properties
    @Value("${countries}")
    private List<String> countries;

    @GetMapping("/signup")
    public String signup(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);

        // to loop countries in select in sign up
//        List<String> countries = new ArrayList<>();
//        countries.add("Brazil");
//        countries.add("German");
//        countries.add("Ukraine");
//        countries.add("USA");
//        countries.add("Mexico");

        model.addAttribute("countries", countries);
        return "signup";
    }

    @GetMapping("/showPersonData")
    public String showData(
            @ModelAttribute("person") Person person
    ) {
        return "signupData";
    }
}
