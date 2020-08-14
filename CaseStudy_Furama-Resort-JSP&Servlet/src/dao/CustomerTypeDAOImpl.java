package dao;

import model.CustomerType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeDAOImpl implements CustomerTypeDAO{
    BaseDAO baseDAO = new BaseDAO();
    private static final String FIND_ALL_CUSTOMER_TYPE = "select * from type_of_customers;";
    @Override
    public List<CustomerType> findAll() {
        List<CustomerType> customerTypeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(FIND_ALL_CUSTOMER_TYPE);
            ResultSet rs = preparedStatement.executeQuery();
            CustomerType customerType = null;
            while (rs.next()){
                customerType = new CustomerType();
                customerType.setId(rs.getInt("id_type_of_customer"));
                customerType.setNameCustomerType(rs.getString("name_type_of_customer"));
                customerTypeList.add(customerType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerTypeList;

    }
}
