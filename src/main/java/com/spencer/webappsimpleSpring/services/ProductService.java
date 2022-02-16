package com.spencer.webappsimpleSpring.services;

import com.spencer.webappsimpleSpring.entities.Product;
import com.spencer.webappsimpleSpring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product getProductByTitle(String title){return productRepository.findOneByTitle(title);}
    public Product getProductById(Long id){
        return  productRepository.getById(id);
    }
    public  List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
