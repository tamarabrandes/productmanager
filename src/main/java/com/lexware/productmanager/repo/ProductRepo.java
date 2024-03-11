package com.lexware.productmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lexware.productmanager.model.Product;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Long> {
    void deleteProductById(Long id);

    Optional <Product>findProductById(Long id);

    Optional <Product>findProductByGtin(Long gtin);
}
