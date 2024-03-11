package com.lexware.productmanager.service;


import com.lexware.productmanager.exception.productNotFoundException;
import com.lexware.productmanager.model.Product;
import com.lexware.productmanager.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProductService {
    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product addProduct(Product product) {
        product.setProductCode(UUID.randomUUID().toString());
        return productRepo.save(product);
    }

    public List<Product> findAllProducts(){
        return productRepo.findAll();
    }

    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    public void deleteProduct(Long id) {
       productRepo.deleteProductById(id);
    }

    public Product findProductById(Long id) throws Throwable {
        return productRepo.findProductById(id)
                .orElseThrow(()-> new productNotFoundException("User with id" + id + "was not found"));
    }

    public Product findProductByGtin(Long gtin) {
        return productRepo.findProductByGtin(gtin).orElse(null);
    }
}
