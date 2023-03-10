package com.inventorymanagementtask.controller;

import com.inventorymanagementtask.model.Category;
import com.inventorymanagementtask.model.Stock;
import com.inventorymanagementtask.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/stocks")
public class StockController {
    @Autowired
    private StockService stockService;
    @GetMapping("/getAll")
    public List<Stock> getAllStock(){
        return stockService.findAll();
    }
    @GetMapping("/stock/{id}")
    public ResponseEntity<Stock> searchCategoryById(@PathVariable("id") int id) throws Exception {
        return new ResponseEntity<Stock>(stockService.findById(id), HttpStatus.FOUND);
    }
    @PostMapping("/save")
    public ResponseEntity<Stock> addStock(@RequestBody Stock stock){
        return new ResponseEntity<>(stockService.addStock(stock), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Stock> updateCategory(@PathVariable("id") int id, @RequestBody Stock stock){
        return new ResponseEntity<Stock>(stockService.updateStock(stock,id), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable("id") int id){
        stockService.deleteStock(id);
    }
}