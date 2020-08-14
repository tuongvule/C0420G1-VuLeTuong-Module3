package bo;

import dao.ServiceTypeDAO;
import dao.ServiceTypeDAOImpl;
import model.ServiceType;

import java.util.List;

public class ServiceTypeBOImpl implements ServiceTypeBO{
    ServiceTypeDAO serviceTypeDAO = new ServiceTypeDAOImpl();
    @Override
    public List<ServiceType> findAll() {
        return this.serviceTypeDAO.findAll();
    }
}
