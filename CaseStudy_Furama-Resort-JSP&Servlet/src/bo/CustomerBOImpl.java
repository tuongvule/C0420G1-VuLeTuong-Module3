package bo;

import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import model.Customer;

import java.util.List;

public class CustomerBOImpl implements CustomerBO{
    CustomerDAO customerDAO = new CustomerDAOImpl();
    @Override
    public List<Customer> findAll() {
        return this.customerDAO.findAll();
    }

    @Override
    public void add(Customer customer) {
        this.customerDAO.add(customer);
    }

    @Override
    public void edit(Customer customer) {
        this.customerDAO.edit(customer);
    }

    @Override
    public void delete(int id) {
        this.customerDAO.delete(id);
    }
}
