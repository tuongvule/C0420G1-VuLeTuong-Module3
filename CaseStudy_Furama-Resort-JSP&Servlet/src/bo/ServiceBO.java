package bo;

import model.Service;

import java.util.List;

public interface ServiceBO {
    List<Service> findAll();
    public void add(Service service);
}
