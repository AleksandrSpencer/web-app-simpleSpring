package com.spencer.webappsimpleSpring.repositories;

import com.spencer.webappsimpleSpring.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long > {
    Product findOneByTitle(String title);
}
