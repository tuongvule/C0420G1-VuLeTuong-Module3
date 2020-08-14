package bo;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.Degree;
import model.Department;
import model.Employee;
import model.Position;

import java.util.List;

public class EmployeeBOImpl implements EmployeeBO{
    EmployeeDAO employeeDAO =new EmployeeDAOImpl();
    @Override
    public List<Employee> findAllEmployee() {
        return this.employeeDAO.findAllEmployee();
    }

    @Override
    public void add(Employee employee) {
        this.employeeDAO.add(employee);
    }

    @Override
    public List<Position> findAllPosition() {
        return this.employeeDAO.findAllPosition();
    }

    @Override
    public List<Degree> findAllDegree() {
        return this.employeeDAO.findAllDegree();
    }

    @Override
    public List<Department> findAllDepartment() {
        return this.employeeDAO.findAllDepartment();
    }

    @Override
    public Employee selectEmployeeById(int id) {
        return this.employeeDAO.selectEmployeeById(id);
    }

    @Override
    public void edit(Employee employee) {
        this.employeeDAO.edit(employee);
    }

    @Override
    public void delete(int id) {
        this.employeeDAO.delete(id);
    }
}
