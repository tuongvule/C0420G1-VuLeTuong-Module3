package bo;

import dao.RentTypeDAO;
import dao.RentTypeDAOImpl;
import model.RentType;

import java.util.List;

public class RentTypeBOImpl implements RentTypeBO {
    RentTypeDAO rentTypeDAO = new RentTypeDAOImpl();
    @Override
    public List<RentType> findAll() {
        return this.rentTypeDAO.findAll();
    }
}
