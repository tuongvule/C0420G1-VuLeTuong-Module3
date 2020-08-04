package bo;

import model.Product;

import java.util.List;

public interface ProductBO {
    List<Product> findAll();
    void save (Product product);
    Product  findById(Integer id);
    void update(Integer id, Product product);
    void remove(Integer id);
}
