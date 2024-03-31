package com.cydeo.controller;


import com.cydeo.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    @RequestMapping("/search-product/{product}")
    public String productPage(Model model, @PathVariable String product){

        ProductServiceImpl productService = new ProductServiceImpl();

        model.addAttribute("productList",productService.searchProduct(product));

        return "product/product-list";
    }
}
