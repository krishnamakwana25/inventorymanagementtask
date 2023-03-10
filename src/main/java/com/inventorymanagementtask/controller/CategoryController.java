package com.inventorymanagementtask.controller;

import com.inventorymanagementtask.model.Category;
import com.inventorymanagementtask.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/getAll")
    public List<Category> getAllCategory(){
        return categoryService.findAll();
    }
    @GetMapping("cat/{id}")
    public ResponseEntity<Category> searchCategoryById(@PathVariable("id") int id) throws Exception {
        return new ResponseEntity<Category>(categoryService.findById(id), HttpStatus.FOUND);
    }
    @PostMapping("/save")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.addCategory(category), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") int id, @RequestBody Category category){
        return new ResponseEntity<Category>(categoryService.updateCategory(category,id), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable("id") int id){
        categoryService.deleteCategory(id);
    }
}
