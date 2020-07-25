import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/Student_index")
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1,"HUy", "12/12/1990",7));
        studentList.add(new Student(2,"Tuong", "09/12/1989",5));
        studentList.add(new Student(3,"Viet", "12/09/1990", 10));
        studentList.add(new Student(4,"Hieu", "19/12/1999", 8));

        request.setAttribute("studentList", studentList);

        request.getRequestDispatcher("showlist.jsp").forward(request,response);
    }
}
