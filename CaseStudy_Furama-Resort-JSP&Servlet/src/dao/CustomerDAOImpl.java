package dao;

import model.Customer;
import model.CustomerType;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO{
    BaseDAO baseDAO = new BaseDAO();
    private static final String FIND_ALL_CUSTOMER = "select * from customers;";
    private static final String ADD_CUSTOMER = "insert into customers (`name`,birthday,id_card,phone_number,email," +
            "address,id_type_of_customer) value (?,?,?,?,?,?,?)";
    private static final String EDIT_CUSTOMER = "update customers set `name`=?,birthday=?,id_card=?,phone_number=?," +
            "email=?,address=?,id_type_of_customer=? where id_customer = ?;";
    private static final String DELETE_CUSTOMER = "delete from customers where id_customer = ?;";




    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(FIND_ALL_CUSTOMER);
            ResultSet rs = preparedStatement.executeQuery();
            Customer customer = null;
            while (rs.next()){
                customer = new Customer();
                customer.setId(rs.getInt("id_customer"));
                customer.setName(rs.getString("name"));
                customer.setBirthday(rs.getString("birthday"));
                customer.setIdCard(rs.getString("id_card"));
                customer.setPhoneNumber(rs.getString("phone_number"));
                customer.setEmail(rs.getString("email"));
                customer.setAddress(rs.getString("address"));
                customer.setIdCustomerType(rs.getString("id_type_of_customer"));
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;

    }

    @Override
    public void add(Customer customer) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(ADD_CUSTOMER);
            preparedStatement.setString(1,customer.getName());
            preparedStatement.setDate(2, Date.valueOf(customer.getBirthday()));
            preparedStatement.setString(3,customer.getIdCard());
            preparedStatement.setString(4,customer.getPhoneNumber());
            preparedStatement.setString(5,customer.getEmail());
            preparedStatement.setString(6,customer.getAddress());
            preparedStatement.setInt(7,Integer.parseInt(customer.getIdCustomerType()));
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void edit(Customer customer) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(EDIT_CUSTOMER);
            preparedStatement.setString(1,customer.getName());
            preparedStatement.setDate(2, Date.valueOf(customer.getBirthday()));
            preparedStatement.setString(3,customer.getIdCard());
            preparedStatement.setString(4,customer.getPhoneNumber());
            preparedStatement.setString(5,customer.getEmail());
            preparedStatement.setString(6,customer.getAddress());
            preparedStatement.setInt(7,Integer.parseInt(customer.getIdCustomerType()));
            preparedStatement.setInt(8,customer.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        try{
            PreparedStatement preparedStatement=this.baseDAO.getConnection().prepareStatement(DELETE_CUSTOMER);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
