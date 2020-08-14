package controller;

import bo.EmployeeBO;
import bo.EmployeeBOImpl;
import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet",urlPatterns = "/employeeServlet")
public class EmployeeServlet extends HttpServlet {
    EmployeeBO employeeBO = new EmployeeBOImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "add":
                confirmAdd(request,response);
                break;

            case "edit":
                confirmEdit(request,response);
                break;

            case "delete":
                confirmDelete(request,response);
                break;
            default:
                break;
        }


    }

    private void confirmEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        String salary = request.getParameter("salary");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int idPosition = Integer.parseInt(request.getParameter("idPosition"));
        int idDegree = Integer.parseInt(request.getParameter("idDegree"));
        int idDepartment = Integer.parseInt(request.getParameter("idDepartment"));
        Employee employee = new Employee(id,name,birthday,idCard,salary,phoneNumber,email,address,idPosition,idDegree,idDepartment);
        this.employeeBO.edit(employee);
        try {
            response.sendRedirect("/employeeServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void confirmDelete(HttpServletRequest request, HttpServletResponse response) {
        Integer id =Integer.parseInt(request.getParameter("id"));
        this.employeeBO.delete(id);
        try {
            response.sendRedirect("/employeeServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void confirmAdd(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String birthday =  request.getParameter("birthday") ;
        String idCard =  request.getParameter("idCard") ;
        String salary = request.getParameter("salary");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address =  request.getParameter("address");
        int idPosition = Integer.parseInt(request.getParameter("idPosition"));
        int idDegree = Integer.parseInt(request.getParameter("idDegree"));
        int idDepartment = Integer.parseInt(request.getParameter("idDepartment"));

        Employee employee = new Employee(name,birthday,idCard,salary,phoneNumber,email,address,idPosition,idDegree,idDepartment);
        this.employeeBO.add(employee);
        try {
            response.sendRedirect("/employeeServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action=request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "edit":
                showEdit(request,response);
                break;

            case "delete":
                showDelete(request,response);
                break;
            default:
                employeeList(request,response);
                break;
        }
////

    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = this.employeeBO.selectEmployeeById(id);
        RequestDispatcher dispatcher= request.getRequestDispatcher("employee/editEmployee.jsp");
        request.setAttribute("employee",employee);
        List<Position> positionList = this.employeeBO.findAllPosition();
        List<Degree> degreeList = this.employeeBO.findAllDegree();
        List<Department> departmentList = this.employeeBO.findAllDepartment();
        request.setAttribute("positionList",positionList);
        request.setAttribute("degreeList",degreeList);
        request.setAttribute("departmentList",departmentList);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) {
        int id=Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id",id);
        try {
            request.getRequestDispatcher("employee/deleteEmployee.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void employeeList(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = this.employeeBO.findAllEmployee();
        List<Position> positionList = this.employeeBO.findAllPosition();
        List<Degree> degreeList = this.employeeBO.findAllDegree();
        List<Department> departmentList = this.employeeBO.findAllDepartment();
        request.setAttribute("employeeList",employeeList);
        request.setAttribute("positionList",positionList);
        request.setAttribute("degreeList",degreeList);
        request.setAttribute("departmentList",departmentList);
        int count=employeeList.size();
        request.setAttribute("count",count);

        try {
            request.getRequestDispatcher("employee/employeeList.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
