package com.femijose.spring.interview.rest;

import com.femijose.spring.interview.Exception.ProductNotFoundException;
import com.femijose.spring.interview.entity.Product;
import com.femijose.spring.interview.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductRestController {

    private ProductService productService;

    @Autowired
    public ProductRestController(ProductService productService) {
       this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> allProduct(){
        return productService.findAll();
    }

    @GetMapping("/{productId}")
    public Product findProduct(@PathVariable int productId) {
        Product product = productService.findProduct(productId);
        if(product == null) {
            throw new ProductNotFoundException("Product ID - "+ productId +" - Not Found");
        }
        return product;
    }

    @PostMapping("/add")
    public Product addProduct(@Valid  @RequestBody Product product) {
        product.setId(0);
        productService.addProduct(product);
        return product;
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return product;
    }



}
