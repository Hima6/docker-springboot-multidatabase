
package com.sample.dockermicroservice.multidatasource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.dockermicroservice.multidatasource.exception.ValidationException;
import com.sample.dockermicroservice.multidatasource.product.domain.Product;
import com.sample.dockermicroservice.multidatasource.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Product productDetails(@PathVariable("id") Long id) {
        return productService.getProductDetails(id);
    }

    @PostMapping
    public Product newProduct(@RequestBody Product product)  {
        return productService.createProduct(product);
    }

    @PutMapping
    public Product updateUser(@RequestBody Product product) throws ValidationException  {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    public void removeProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
    
}
