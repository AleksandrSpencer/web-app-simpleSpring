package com.spencer.webappsimpleSpring.controllers;
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
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class MainController {

        private ProductService productService;

        @Autowired
        public void setProductService(ProductService productService) {

            this.productService = productService;
        }

        @GetMapping("/index")
        public String homePage() {
            return "index";
        }

        @GetMapping("/login")
        public String login() {
            return "login";
        }

        @GetMapping("/shop")
        public String shopPage(Model model) {
            List<Product> allProducts = productService.getAllProducts();
            model.addAttribute("products", allProducts);
            return "shop";
        }

        @GetMapping("/details/{id}")
        public String detailsPage(Model model, @PathVariable("id") Long id) {
            Product selectedProduct = productService.getProductById(id);
            model.addAttribute("selectedProduct", selectedProduct);
            return "details";
        }

        @GetMapping("/find_by_title")
        public String detailsPageByTitle(Model model, @RequestParam("title") String title) {
            Product selectedProduct = productService.getProductByTitle(title);
            model.addAttribute("selectedProduct", selectedProduct);
            return "details";
        }

        @GetMapping("/products/delete/{id}")
        public String deleteProductById(@PathVariable("id") Long id) {
            productService.deleteProductById(id);
            return "redirect:/shop";
        }

        @GetMapping("/data")
        @ResponseBody
        public String dataExample(@RequestParam(value = "serial") Long serial, @RequestParam("number") Long number) {
            return "S/N: " + serial + " / " + number;
        }
    }