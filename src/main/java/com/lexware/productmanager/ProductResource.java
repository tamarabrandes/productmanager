package com.lexware.productmanager;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lexware.productmanager.model.Product;
import com.lexware.productmanager.service.ProductService;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@CrossOrigin
@RestController
@SecurityRequirement(name = "admin")
//@RequestMapping("/product")
public class ProductResource {
    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @CrossOrigin
    @GetMapping("/product/all")
    public ResponseEntity <List<Product>> getAllProducts(){
        List<Product> products = productService.findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/product/find/{id}")
    public ResponseEntity <Product> getAllProductById(@PathVariable ("id") Long id) throws Throwable {
        Product product = productService.findProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @GetMapping("/product/findgtin/{gtin}")
    public ResponseEntity <Product> getAllProductByGtin(@PathVariable ("gtin") Long gtin) {
        Product product = productService.findProductByGtin(gtin);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @PostMapping("/product/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
    Product newProduct = productService.addProduct(product);
    return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/product/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        Product updateProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updateProduct, HttpStatus.CREATED);
    }

    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable ("id") Long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
