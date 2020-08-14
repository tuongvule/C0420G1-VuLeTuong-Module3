package bo;

import dao.ServiceDAO;
import dao.ServiceDAOImpl;
import model.Service;

import java.util.List;

public class ServiceBOImpl implements ServiceBO{
    ServiceDAO serviceDAO = new ServiceDAOImpl();
    @Override
    public List<Service> findAll() {
        return this.serviceDAO.findAll();
    }

    @Override
    public void add(Service service) {
        this.serviceDAO.add(service);
    }
}
