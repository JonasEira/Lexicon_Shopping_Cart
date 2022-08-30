package com.lexicon.data;

import com.lexicon.model.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartDAO {
    ShoppingCart save(ShoppingCart p);
    Optional<ShoppingCart> findById(int id);
    List<ShoppingCart> findAll();
    List<ShoppingCart> findByName(String name);
    List<ShoppingCart> findByPriceBetween(int low, int high);
    void delete(int id);
}
