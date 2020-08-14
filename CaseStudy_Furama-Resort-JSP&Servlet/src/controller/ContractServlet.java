package controller;

import bo.*;
import model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractServlet", urlPatterns = "/contractServlet")
public class ContractServlet extends HttpServlet {
    ContractBO contractBO = new ContractBOImpl();
    EmployeeBO employeeBO =new EmployeeBOImpl();
    CustomerBO customerBO = new CustomerBOImpl();
    ServiceBO serviceBO = new ServiceBOImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        Integer deposit = Integer.parseInt(request.getParameter("deposit"));
        Integer totalMoney = Integer.parseInt(request.getParameter("totalMoney"));
        Integer idEmployee = Integer.parseInt(request.getParameter("idEmployee"));
        Integer idCustomer = Integer.parseInt(request.getParameter("idCustomer"));
        Integer idService = Integer.parseInt(request.getParameter("idService"));

        Contract contract = new Contract(startDate,endDate,deposit,totalMoney,idEmployee,idCustomer,idService);
        this.contractBO.add(contract);
        try {
            response.sendRedirect("home.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = this.employeeBO.findAllEmployee();
        List<Customer> customerList = this.customerBO.findAll();
        List<Service> serviceList = this.serviceBO.findAll();
//        List<Contract> contractList = this.contractBO.findAll();
        request.setAttribute("employeeList",employeeList);
        request.setAttribute("customerList",customerList);
        request.setAttribute("serviceList",serviceList);
        request.getRequestDispatcher("contract/addContract.jsp").forward(request,response);

    }
}
