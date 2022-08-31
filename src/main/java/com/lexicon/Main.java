package com.lexicon;

import com.lexicon.data.ProductDAO;
import com.lexicon.data.ProductDAOImpl;
import com.lexicon.model.Product;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        ProductDAO pDao = new ProductDAOImpl();

        //pDao.save(p);
        Optional<Product> isProduct = pDao.findById(1);
        Product p = isProduct.get();
        System.out.println("p = " + p);;

        List<Product> listOfProds = pDao.findAll();
        for(Product product : listOfProds){
            System.out.println(product);
        }


    }
}