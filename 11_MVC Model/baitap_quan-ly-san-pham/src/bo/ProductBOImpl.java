package bo;

import dao.ProductDAO;
import dao.ProductDAOImpl;
import model.Product;

import java.util.List;

public class ProductBOImpl implements ProductBO {
    private ProductDAO productDAO = new ProductDAOImpl();

    @Override
    public List<Product> findAll() {
        return this.productDAO.findAll();
    }

    @Override
    public void save(Product product) {
        this.productDAO.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return this.productDAO.findById(id);
    }

    @Override
    public void update(Integer id, Product product) {
        this.productDAO.update(id, product);
    }

    @Override
    public void remove(Integer id) {
        this.productDAO.remove(id);
    }
}
