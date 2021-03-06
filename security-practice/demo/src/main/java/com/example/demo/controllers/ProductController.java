package com.example.demo.controllers;

import java.util.List;

import com.example.demo.models.ProductDO;
import com.example.demo.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @RequestMapping("/new")
    public String createProduct(Model model){
        ProductDO newProduct = new ProductDO();
        model.addAttribute("product", newProduct);
        //Returns the name of the related html page.
        return "new_product";
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") ProductDO product){
        productService.saveProduct(product);

        return "redirect:/";
    }

    @RequestMapping("/edit/{productId}")
    public ModelAndView updateProduct(@PathVariable Long productId){
        ModelAndView mv = new ModelAndView("edit_product");
        ProductDO product = productService.getProduct(productId);
        mv.addObject("product", product);

        return mv;
    }

    @RequestMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable Long productId){
        productService.deleteProduct(productId);
        return "redirect:/";
    }

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<ProductDO> products = productService.getAllProducts();
        model.addAttribute("listAllProducts", products);

        return "index";
    }
    
    @RequestMapping(value="/403", method=RequestMethod.GET)
    public String error403() {
        return "403";
    }
    
}
