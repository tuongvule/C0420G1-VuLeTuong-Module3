import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet", urlPatterns = "/sum")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String a = request.getParameter("number1");
String b = request.getParameter("number2");
double result = Double.parseDouble(a) + Double.parseDouble(b);
request.setAttribute("res", result);
request.getRequestDispatcher("final.jsp").forward(request,response);
    }
}
