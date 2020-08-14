package bo;

import model.Degree;
import model.Department;
import model.Employee;
import model.Position;

import java.util.List;

public interface EmployeeBO {
    List<Employee> findAllEmployee();
    public void add(Employee employee);
    List<Position> findAllPosition();
    List<Degree> findAllDegree();
    List<Department> findAllDepartment();
    Employee selectEmployeeById(int id);
    void edit(Employee employee);
    void delete(int id);
}
