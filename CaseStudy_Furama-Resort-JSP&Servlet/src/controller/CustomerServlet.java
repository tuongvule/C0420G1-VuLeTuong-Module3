package controller;

import bo.CustomerBO;
import bo.CustomerBOImpl;
import bo.CustomerTypeBO;
import bo.CustomerTypeBOIplm;
import model.Customer;
import model.CustomerType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ClientInfoStatus;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customerServlet")
public class CustomerServlet extends HttpServlet {
    CustomerBO customerBO = new CustomerBOImpl();
    CustomerTypeBO customerTypeBO = new CustomerTypeBOIplm();
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
                listCustomer(request,response);
                break;
        }
    }

    private void confirmDelete(HttpServletRequest request, HttpServletResponse response) {
        Integer id =Integer.parseInt(request.getParameter("id"));
        this.customerBO.delete(id);
        try {
            response.sendRedirect("/customerServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void confirmEdit(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String idCustomerType = request.getParameter("idCustomerType");
        Customer customer = new Customer(id,name,birthday,idCard,phoneNumber,email,address,idCustomerType);
        this.customerBO.edit(customer);
        try {
            response.sendRedirect("/customerServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void confirmAdd(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String idCustomerType = request.getParameter("idCustomerType");
        Customer customer = new Customer(name,birthday,idCard,phoneNumber,email,address,idCustomerType);
        this.customerBO.add(customer);
        try {
            response.sendRedirect("/customerServlet");
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
                listCustomer(request,response);
                break;
        }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) {
        int id=Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id",id);
        try {
            request.getRequestDispatcher("customer/deleteCustomer.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        int id=Integer.parseInt(request.getParameter("id"));
        int idEdit=0;
        List<Customer> customerList = customerBO.findAll();
        for(int i=0;i<customerList.size();i++){
            if(id==customerList.get(i).getId()){
                idEdit=i;
            }
        }
        String name=customerList.get(idEdit).getName();
        String birthday=customerList.get(idEdit).getBirthday();
        String idCard=customerList.get(idEdit).getIdCard();
        String phoneNumber=customerList.get(idEdit).getPhoneNumber();
        String email=customerList.get(idEdit).getEmail();
        String address=customerList.get(idEdit).getAddress();
        String idCustomerType=customerList.get(idEdit).getIdCustomerType();

        Customer customer = new Customer(id,name,birthday, idCard, phoneNumber, email, address, idCustomerType);
        request.setAttribute("customer", customer);
        List<CustomerType> customerTypeList=customerTypeBO.findAll();
        request.setAttribute("customerTypeList",customerTypeList);

        try {
            request.getRequestDispatcher("customer/editCustomer.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList=customerBO.findAll();
        request.setAttribute("customerList",customerList);
        List<CustomerType> customerTypeList= this.customerTypeBO.findAll();
        int count=customerList.size();
        request.setAttribute("count",count);
        request.setAttribute("customerList",customerList);
        request.setAttribute("customerTypeList",customerTypeList);
        try {
            request.getRequestDispatcher("customer/customerList.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
