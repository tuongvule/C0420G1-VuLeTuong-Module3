package dao;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDAOImpl implements ProductDAO {
    private static Map<Integer, Product> productMap;
    static {
        productMap = new HashMap<>();
        productMap.put(1,new Product(1, "Guitar", "9000", "Martin, Japan","Instrument"));
        productMap.put(2,new Product(2, "Flute", "3000", "Mao Meo, Viet Nam","Instrument"));
        productMap.put(3,new Product(3, "Drum", "20000", "Yamaha, Japan","Instrument"));
        productMap.put(4,new Product(4, "Ukulele", "4000", "Bejing, China","Instrument"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(Integer id) {
        return productMap.get(id);
    }

    @Override
    public Product update(Integer id, Product product) {
        return productMap.put(id, product);
    }

    @Override
    public void remove(Integer id) {
        productMap.remove(id);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productList = new ArrayList<>(productMap.values());
        List<Product> products = new ArrayList<>();
        int size = productList.size();
        for (int i = 0; i < size; i++) {
            if (name.equals(productList.get(i).getName())){
                products.add(productList.get(i));
            }
        }
        return products;
    }
}
