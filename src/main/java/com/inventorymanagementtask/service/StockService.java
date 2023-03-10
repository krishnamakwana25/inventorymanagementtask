package com.inventorymanagementtask.service;

import com.inventorymanagementtask.model.Category;
import com.inventorymanagementtask.model.Stock;
import com.inventorymanagementtask.repository.StockRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Transactional
@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    public Optional<?>FindById(int id){
        return stockRepository.findById(id);
    }

    public Stock addStock(Stock stock){
        return stockRepository.save(stock);
    }
    public Stock findById(int id) throws Exception {
        Optional<Stock> stock= stockRepository.findById(id);
        if(stock.isPresent()){
            return stock.get();
        }
        throw new Exception();
    }
    public List<Stock> findAll(){
        return stockRepository.findAll();
    }
    public Stock updateStock(Stock stock, int id){
        Stock checkStock = stockRepository.findById(id).orElseThrow();
        checkStock.setBranchId(stock.getBranchId());
        checkStock.setCreateUser(stock.getCreateUser());
        checkStock.setCategory(stock.getCategory());
        checkStock.setProducts(stock.getProducts());


        stockRepository.save(checkStock);
        return checkStock;
    }

    public void deleteStock(int id ){
        stockRepository.findById(id).orElseThrow();
        stockRepository.deleteById(id);
    }
}
