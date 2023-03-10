package com.inventorymanagementtask.service;

import com.inventorymanagementtask.model.Category;
import com.inventorymanagementtask.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }
    public Category findById(int id) throws Exception {
        Optional<Category> category= categoryRepository.findById(id);
        if(category.isPresent()){
            return category.get();
        }
        throw new Exception();
    }
    public List<Category> findAll(){
      return categoryRepository.findAll();
    }
    public Category updateCategory(Category category, int id){
        Category checkCategory = categoryRepository.findById(id).orElseThrow();
        checkCategory.setCategoryName(category.getCategoryName());
        categoryRepository.save(checkCategory);
        return checkCategory;
    }

    public void deleteCategory(int id ){
        categoryRepository.findById(id).orElseThrow();
        categoryRepository.deleteById(id);
    }
}

