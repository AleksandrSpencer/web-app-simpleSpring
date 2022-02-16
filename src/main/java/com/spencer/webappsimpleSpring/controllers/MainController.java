package com.spencer.webappsimpleSpring.controllers;
import java.math.BigDecimal;
import java.util.List;

import com.spencer.webappsimpleSpring.entities.Product;
import com.spencer.webappsimpleSpring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    //http://localhost:8189/app/index
    @GetMapping("/index")
    public String homePage (){
        return "index";
    }

    @GetMapping("/login")
    public String login() { return "login";
    }
    @GetMapping("/shop")
    public String shopPage (Model model) {
        List<Product> allProducts = productService.getAllProducts();
        model.addAttribute("prod", allProducts);
        return "shop";
    }
    @GetMapping("/details/{id}")
    public String detailsPage (Model model, @PathVariable("id") Long id) {
        Product selectProd = productService.getProductById(id);
        model.addAttribute("selectProd", selectProd);
        return "details";
    }
    @GetMapping("/find_by_tile")
    public String detailsPageByTitle (Model model, @RequestParam("title") String title) {
        Product selectProd = productService.getProductByTitle(title);
        model.addAttribute("selectProd", selectProd);
        return "details";
    }
    @GetMapping("/products/delete/{id}")
    public String deleteProductById(@PathVariable("id") Long id){
    productService.deleteProductById(id);
    return "redirect:/shop";
    }
    @GetMapping("/data")
    @ResponseBody
    public String dateExample(@RequestParam(value = "serial",required = false)Long serial, @RequestParam(value = "number", required = false)Long number){

        return "S/N: "+serial+" / "+number;
    }
    }
