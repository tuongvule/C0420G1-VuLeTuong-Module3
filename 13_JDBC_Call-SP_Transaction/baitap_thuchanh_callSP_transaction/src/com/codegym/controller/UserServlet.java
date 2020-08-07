package com.codegym.controller;

import com.codegym.bo.UserBO;
import com.codegym.bo.UserBOImpl;
import com.codegym.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/userServlet")
public class UserServlet extends HttpServlet {
    private UserBO userBO = new UserBOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
        switch (action) {
            case "create":
                    createUser(request, response);
                break;
            case "edit":
                updateUser(request, response);
                break;
            case "delete":
                deleteUser(request, response);
                break;
            case "search-by-country":
                searchUserByCountry(request, response);

            default:
                break;
        }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private void searchUserByCountry(HttpServletRequest request, HttpServletResponse response) {
        String country = request.getParameter("country");
        List<User> userList = this.userBO.findByCountry(country);
        RequestDispatcher dispatcher;
        if (userList == null) {
            dispatcher = request.getRequestDispatcher("error_404.jsp");
        } else {
            request.setAttribute("userList", userList);
            dispatcher = request.getRequestDispatcher("user/list.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = this.userBO.findById(id);
        RequestDispatcher dispatcher;
        if (user == null) {
            dispatcher = request.getRequestDispatcher("error_404.jsp");
        } else {
            this.userBO.remove(id);
            try {
                response.sendRedirect("/userServlet");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = this.userBO.findById(id);
        RequestDispatcher dispatcher;
        if (user == null) {
            dispatcher = request.getRequestDispatcher("error_404.jsp");
        } else {
            user.setName(name);
            user.setEmail(email);
            user.setCountry(country);
            this.userBO.update(id, user);
            request.setAttribute("user", user);
            request.setAttribute("message", "User information was updated");
            dispatcher = request.getRequestDispatcher("user/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setCountry(country);

//        this.userBO.save(user);
        this.userBO.insertUserStore(user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        request.setAttribute("message", "New user was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
////        Nếu không dùng message,
////        bỏ từ line RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "search-by-country":
                showSearchByCountryForm(request, response);
                break;
            case "view":
//                viewUser(request, response);
                break;
            case "search":
//                showSearchForm(request, response);
            case "permision":
                addUserPermision(request, response);
                break;
            case "test-without-tran":

//                testWithoutTran(request, response);
                break;
            case "test-use-tran":
//                testUseTran(request, response);
                break;
            default:
                listUser(request, response);
                break;
        }
    }

//    private void testUseTran(HttpServletRequest request, HttpServletResponse response) {
//        userBO.insertUpdateUseTransaction();
//    }
//
//    private void testWithoutTran(HttpServletRequest request, HttpServletResponse response) {
//
//        userBO.insertUpdateWithoutTransaction();
//    }

    private void addUserPermision(HttpServletRequest request, HttpServletResponse response) {
        User user = new User("kien","kienhoang@gmail.com","vn");

        int[] permision = {1, 2, 4};

//        userBO.addUserTransaction(user, permision);

    }

    private void showSearchByCountryForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/search.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = this.userBO.findById(id);
        RequestDispatcher dispatcher;
        if (user == null) {
            dispatcher = request.getRequestDispatcher("error_404.jsp");
        } else {
            request.setAttribute("user", user);
            dispatcher = request.getRequestDispatcher("user/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
//        User user = this.userBO.findById(id);
        User user = this.userBO.getUserById(id);
        RequestDispatcher dispatcher;
        if (user == null) {
            dispatcher = request.getRequestDispatcher("error_404.jsp");
        } else {
            request.setAttribute("user", user);
            dispatcher = request.getRequestDispatcher("user/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) {
//        List<User> userList = userBO.getAll();
        List<User> userList = userBO.findAll();
        request.setAttribute("userList", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
