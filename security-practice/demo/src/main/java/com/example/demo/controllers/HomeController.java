package com.example.demo.controllers;

import java.util.List;

import com.example.demo.models.ProductDO;
import com.example.demo.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    
    @Autowired
    private ProductService productService;


    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<ProductDO> products = productService.getAllProducts();
        model.addAttribute("listAllProducts", products);

        return "index";
    }
    
}
