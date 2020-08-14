package dao;

import model.Service;

import java.util.List;

public interface ServiceDAO {
    List<Service> findAll();
    public void add(Service service);
}
