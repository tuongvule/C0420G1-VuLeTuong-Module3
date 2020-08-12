package bo;

import model.Customer;

import java.util.List;

public interface CustomerBO {
    List<Customer> findAll();
    void add(Customer customer);
    void edit(Customer customer);
    void delete(int id);
}
