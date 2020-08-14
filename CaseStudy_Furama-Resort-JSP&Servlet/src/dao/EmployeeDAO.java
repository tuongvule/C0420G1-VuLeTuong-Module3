package dao;

import model.*;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAllEmployee();
    public void add(Employee employee);
    List<Position> findAllPosition();
    List<Degree> findAllDegree();
    List<Department> findAllDepartment();
    Employee selectEmployeeById(int id);
    void edit(Employee employee);
    void delete(int id);

}
