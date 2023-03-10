package com.inventorymanagementtask.controller;

import com.inventorymanagementtask.model.Category;
import com.inventorymanagementtask.model.Products;
import com.inventorymanagementtask.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/getAll")
    public List<Products> getAllProducts() {
        return productService.findAll();
    }
    @GetMapping("getId/{id}")
    public ResponseEntity<Products> findProductById(@PathVariable("id") int id) throws Exception {
        return new ResponseEntity<Products>(productService.findByProductId(id), HttpStatus.FOUND);
    }
    @PostMapping("/save")
    public ResponseEntity<Products> addProduct(@RequestBody Products category) {
        return new ResponseEntity<>(productService.addProducts(category),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Products> updateCategory(@PathVariable("id") int id, @RequestBody Products products) {
        return new ResponseEntity<Products>(productService.updateProduct(products, id), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteProductById(@PathVariable("id") int id) {
        productService.deleteProduct(id);
    }
}