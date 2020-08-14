package dao;

import model.*;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    BaseDAO baseDAO = new BaseDAO();
    private static final String FIND_ALL_EMPLOYEE = "select * from employees";
    private static final String ADD_NEW_EMPLOYEE = "insert into employees (`name`,birthday,id_card,salary,phone_number," +
            "email,address,id_position,id_degree,id_department) value (?,?,?,?,?,?,?,?,?,?)";
    private static final String FIND_ALL_POSITION = "select * from positions ";
    private static final String FIND_ALL_DEGREE = "select * from degrees";
    private static final String FIND_ALL_DEPARTMENT = "select * from departments";
    private static final String SELECT_EMPLOYEE_BY_ID ="select * from employees where id_employee =?";
    private static final String EDIT_EMPLOYEE = "update employees set `name`=?,birthday=?,id_card=?,salary=?,phone_number=?," +
            "email=?,address=?,id_position=?,id_degree = ?,id_department =? where id_employee = ?;";
    private static final String DELETE_EMPLOYEE = "delete from employees where id_employee = ?;";
    @Override
    public List<Employee> findAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = baseDAO.getConnection().prepareStatement(FIND_ALL_EMPLOYEE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                employee = new Employee();
                employee.setId(resultSet.getInt("id_employee"));
                employee.setName(resultSet.getString("name"));
                employee.setBirthday(resultSet.getString("birthday"));
                employee.setIdCard(resultSet.getString("id_card"));
                employee.setSalary(resultSet.getString("salary"));
                employee.setPhoneNumber(resultSet.getString("phone_number"));
                employee.setEmail(resultSet.getString("email"));
                employee.setAddress(resultSet.getString("address"));
                employee.setIdPosition(resultSet.getInt("id_position"));
                employee.setIdDegree(resultSet.getInt("id_degree"));
                employee.setIdDepartment(resultSet.getInt("id_department"));
                employeeList.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;

    }

    @Override
    public void add(Employee employee) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(ADD_NEW_EMPLOYEE);
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setDate(2, Date.valueOf(employee.getBirthday()));
            preparedStatement.setString(3,employee.getIdCard());
            preparedStatement.setString(4,employee.getSalary());
            preparedStatement.setString(5, employee.getPhoneNumber());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7,employee.getAddress());
            preparedStatement.setInt(8,employee.getIdPosition());
            preparedStatement.setInt(9,employee.getIdDegree());
            preparedStatement.setInt(10,employee.getIdDepartment());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public List<Position> findAllPosition() {
        List<Position> positionList = new ArrayList<>();
        Position position = null;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(FIND_ALL_POSITION);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                position = new Position();
                position.setId(resultSet.getInt("id_position"));
                position.setNamePosition(resultSet.getString("name_position"));
                positionList.add(position);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return positionList;
    }

    @Override
    public List<Degree> findAllDegree() {
        List<Degree> degreeList = new ArrayList<>();
        Degree degree = null;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(FIND_ALL_DEGREE);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                degree = new Degree();
                degree.setId(resultSet.getInt("id_degree"));
                degree.setNameDegree(resultSet.getString("degree"));
                degreeList.add(degree);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return degreeList;
    }

    @Override
    public List<Department> findAllDepartment() {
        List<Department> departmentList = new ArrayList<>();
        Department department = null;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(FIND_ALL_DEPARTMENT);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                department = new Department();
                department.setId(resultSet.getInt("id_department"));
                department.setNameDepartment(resultSet.getString("name_department"));
                departmentList.add(department);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return departmentList;
    }

    @Override
    public Employee selectEmployeeById(int id) {
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_EMPLOYEE_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
//                int id =rs.getInt("id_employee");
                String name = rs.getString("name");
                String birthday = rs.getString("birthday");
                String idCard = rs.getString("id_card");
                String salary = rs.getString("salary");
                String phoneNumber =rs.getString("phone_number");
                String email =rs.getString("email");
                String address =rs.getString("address");
                int idPosition =rs.getInt("id_position");
                int idDegree =rs.getInt("id_degree");
                int idDepartment =rs.getInt("id_department");
                employee = new Employee(id,name,birthday,idCard,salary,phoneNumber,email,address,idPosition,idDegree,idDepartment);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }

    @Override
    public void edit(Employee employee) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(EDIT_EMPLOYEE);
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setDate(2, Date.valueOf(employee.getBirthday()));
            preparedStatement.setString(3,employee.getIdCard());
            preparedStatement.setString(4,employee.getSalary());
            preparedStatement.setString(5,employee.getPhoneNumber());
            preparedStatement.setString(6,employee.getEmail());
            preparedStatement.setString(7,employee.getAddress());
            preparedStatement.setInt(8,employee.getIdPosition());
            preparedStatement.setInt(9,employee.getIdDegree());
            preparedStatement.setInt(10,employee.getIdDegree());
            preparedStatement.setInt(11,employee.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        try{
            PreparedStatement preparedStatement=this.baseDAO.getConnection().prepareStatement(DELETE_EMPLOYEE);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
