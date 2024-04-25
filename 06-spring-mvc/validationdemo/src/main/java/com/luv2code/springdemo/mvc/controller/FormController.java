package com.luv2code.springdemo.mvc.controller;

import com.luv2code.springdemo.mvc.model.Person;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class FormController {
    @GetMapping("/form")
    public String userForm(Model model) {
        model.addAttribute("person", new Person());
        return "userForm";
    }

    @PostMapping("/showData")
    public String userData(@Valid @ModelAttribute("person") Person person,
                           BindingResult theBindingResult) {
        if (theBindingResult.hasErrors()) {
            return "userForm";
        } else {
            return "userData";
        }

    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}
