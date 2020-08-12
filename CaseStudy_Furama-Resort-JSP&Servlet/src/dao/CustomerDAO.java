package dao;

import model.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> findAll();
    void add(Customer customer);
    void edit(Customer customer);
    void delete(int id);
}
