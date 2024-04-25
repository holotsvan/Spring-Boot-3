package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DemoController {

    @GetMapping("/hello")
    public String sayHello(Model model) {

        model.addAttribute("theDate", java.time.LocalDateTime.now());

        return "helloworld";
    }

    @GetMapping("/product")
    public String showProductCatalog(Model model) {
        // Dummy data for demonstration
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Product 1", "Description for Product 1", 19.99));
        products.add(new Product(2, "Product 2", "Description for Product 2", 29.99));
        products.add(new Product(3, "Product 3", "Description for Product 3", 39.99));

        // Add products to the model
        model.addAttribute("products", products);

        // Return the name of the Thymeleaf template
        return "productCatalog";
    }

}
