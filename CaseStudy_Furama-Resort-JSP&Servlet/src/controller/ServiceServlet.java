package controller;

import bo.*;
import dao.ServiceDAO;
import model.RentType;
import model.Service;
import model.ServiceType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/serviceServlet")
public class ServiceServlet extends HttpServlet {
    ServiceBO serviceBO = new ServiceBOImpl();
    RentTypeBO rentTypeBO = new RentTypeBOImpl();
    ServiceTypeBO serviceTypeBO = new ServiceTypeBOImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Integer area = Integer.parseInt(request.getParameter("area"));
        Integer floor = Integer.parseInt(request.getParameter("floor"));
        String numberOfPeople = request.getParameter("numberOfPeople");
        String cost = request.getParameter("cost");
        String status = request.getParameter("status");
        Integer idRentType = Integer.parseInt(request.getParameter("idRentType"));
        Integer idServiceType = Integer.parseInt(request.getParameter("idServiceType"));

        Service service = new Service(name, area,floor,numberOfPeople,cost,status,idRentType,idServiceType);
        this.serviceBO.add(service);
        try {
            response.sendRedirect("/customerServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Service> serviceList = this.serviceBO.findAll();
        List<RentType> rentTypeList = this.rentTypeBO.findAll();
        List<ServiceType> serviceTypeList = this.serviceTypeBO.findAll();
//        request.setAttribute("serviceList",serviceList);
        request.setAttribute("rentTypeList",rentTypeList);
        request.setAttribute("serviceTypeList",serviceTypeList);
        request.getRequestDispatcher("service/addService.jsp").forward(request,response);

    }
}
