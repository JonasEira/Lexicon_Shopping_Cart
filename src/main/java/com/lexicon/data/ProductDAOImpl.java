package com.lexicon.data;

import com.lexicon.model.Product;
import com.lexicon.utilities.MyCredentials;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class ProductDAOImpl implements ProductDAO{

    Connection sqlConn;
    MyCredentials m = new MyCredentials();

    @Override
    public Product save(Product p) {
        try {
            System.out.println("Save called: " + m);
            sqlConn = DriverManager.getConnection(m.getUrl(),m.getName(),m.getPassword());
            PreparedStatement statement = sqlConn.prepareStatement(
                          "INSERT INTO shopping_practice.product (id, name, price) "
                            + "VALUES (?, ?, ?)"
            );
            statement.setInt(1, p.getId());
            statement.setString(2, p.getName());
            statement.setDouble(3, p.getPrice());
            System.out.println(statement);
            boolean worked = statement.execute();
            System.out.println("worked = " + worked);
            sqlConn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Optional<Product> findById(int id) {
        try {
            Product p = new Product();
            System.out.println("Save called: " + m);
            sqlConn = DriverManager.getConnection(m.getUrl(),m.getName(),m.getPassword());
            PreparedStatement statement = sqlConn.prepareStatement(
                    "SELECT * FROM shopping_practice.product WHERE ID = ?"
            );
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet result = statement.executeQuery();
            result.next();
            p.setId(result.getInt("id"));
            p.setName(result.getString("name"));
            p.setPrice(result.getDouble("price"));
            sqlConn.close();
            return Optional.of(p);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }

    @Override
    public List<Product> findByPriceBetween(int low, int high) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
