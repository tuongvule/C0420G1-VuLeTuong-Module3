package dao;

import model.Customer;
import model.CustomerType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO{
    BaseDAO baseDAO = new BaseDAO();
    private static final String FIND_ALL_CUSTOMER = "select name_type_of_customer from customers;";
    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(FIND_ALL_CUSTOMER);
            ResultSet rs = preparedStatement.executeQuery();
            Customer customer = null;
            while (rs.next()){
                customer = new Customer();
                customer.setId(rs.getInt("id_type_of_customer"));
                customer.set(rs.getString("name_type_of_customer"));
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerTypeList;

//        private int id;
//        private String name;
//        private String birthday;
//        private String idCard;
//        private String salary;
//        private String phoneNumber;
//        private String email;
//        private String idCustomer;
    }

    @Override
    public void add(Customer customer) {

    }

    @Override
    public void edit(Customer customer) {

    }

    @Override
    public void delete(int id) {

    }
}
