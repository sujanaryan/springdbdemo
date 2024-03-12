package com.march.dbdemo.controller;

import com.march.dbdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Value("${successfull.message}")
    private String successfulMessage;

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/product/action/add")
    public ResponseEntity<?> addProduct(@RequestBody String productId, @RequestBody String productName) {
        productService.addProduct(productId, productName);
        return new ResponseEntity<>(successfulMessage, HttpStatus.OK);
    }
}
