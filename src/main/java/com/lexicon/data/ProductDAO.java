package com.lexicon.data;

import com.lexicon.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDAO {
    Product save(Product p);
    Optional<Product> findById(int id);
    List<Product> findAll();
    List<Product> findByName(String name);
    List<Product> findByPriceBetween(int low, int high);
    void delete(int id);
}
