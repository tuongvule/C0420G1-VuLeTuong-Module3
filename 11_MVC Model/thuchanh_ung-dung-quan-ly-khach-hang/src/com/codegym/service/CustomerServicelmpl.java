package com.codegym.service;

import com.codegym.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServicelmpl implements CustomerService {
    private static Map<Integer, Customer> customers;
    static {
        customers = new HashMap<>();
        customers.put(1,new Customer(1,"Kim","kim@gmail.com","Bình Sa"));
        customers.put(2,new Customer(2,"Hiền","hien@gmail.com","Bình Sa"));
        customers.put(3,new Customer(3,"Ngân","ngan@gmail.com","Bình Sa"));
        customers.put(4,new Customer(4,"Tiến","tien@gmail.com","Bình Sa"));
        customers.put(5,new Customer(5,"Phước","phuoc@gmail.com","Bình Sa"));
        customers.put(6,new Customer(6,"Tường","tuong@gmail.com","Bình Sa"));
    }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.put(id,customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }
}
