package dao;

import model.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> findAll();
    void save(Product product);
    Product findById(Integer id);
    Product update(Integer id, Product product);
    void remove(Integer id);
    List<Product> search(String name);
}
