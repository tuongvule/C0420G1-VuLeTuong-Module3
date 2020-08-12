package dao;

import model.CustomerType;

import java.util.List;

public interface CustomerTypeDAO {
    List<CustomerType> findAll();
}
