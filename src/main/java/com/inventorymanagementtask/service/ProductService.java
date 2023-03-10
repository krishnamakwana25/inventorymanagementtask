package com.inventorymanagementtask.service;

import com.inventorymanagementtask.model.Products;
import com.inventorymanagementtask.model.Stock;
import com.inventorymanagementtask.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Transactional
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public Products addProducts(Products products){
       return  productRepository.save(products);
    }
    public Products findByProductId(int id) throws Exception {
        Optional<Products> products = productRepository.findById(id);
        if(products .isPresent()){
            return products.get();
        }
        throw new Exception();
    }

    public Products updateProduct(Products products, int id){
        Products checkProduct = productRepository.findById(id).orElseThrow();
        products.setProductName(products.getProductName());
        checkProduct.setProductPrice(products.getProductPrice());
        checkProduct.setProductQuantity(products.getProductQuantity());
        checkProduct.setStocks(products.getStocks());
        checkProduct.setCategory(products.getCategory());

        productRepository.save(checkProduct);
        return checkProduct;
    }
    public List<Products> findAll(){
        return productRepository.findAll();
    }
    public void deleteProduct(int id){
        productRepository.findById(id).orElseThrow();
        productRepository.deleteById(id);
    }
}