package BO;

import DAO.ProductDao;
import DAO.ProductDaoImpl;
import model.Product;

import java.util.List;

public class ProductBOImpl implements ProductBO{
    private ProductDao productDao = new ProductDaoImpl();

    @Override
    public List<Product> findAll() {
        return this.productDao.findAll();
    }

    @Override
    public void save(Product product) {
        this.productDao.save(product);
    }

    @Override
    public Product findById(int id) {
        return this.productDao.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        this.productDao.update(id,product);
    }

    @Override
    public void remove(int id) {
        this.productDao.remove(id);
    }
}
