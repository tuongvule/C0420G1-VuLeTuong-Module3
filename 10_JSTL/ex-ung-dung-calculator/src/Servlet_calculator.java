import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet_calculator", urlPatterns = "/calculator_index")
public class Servlet_calculator extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float first_operand = Float.parseFloat(request.getParameter("first_operand"));
        float second_operand = Float.parseFloat(request.getParameter("second_operand"));
        char operator = request.getParameter("operator").charAt(0);
        PrintWriter writer = response.getWriter();
        float result = 0;
        writer.println("<html>");
        writer.println("<h1>Result</h1>");
        try {
            result = Calculator.calculator(first_operand,second_operand,operator);
            writer.println(first_operand +" "+ operator + " "+ second_operand+" = "+ result );
        }catch (Exception e){
            writer.println("Error: " + e.getMessage());
        }
        writer.println("</html>");
//        request.setAttribute("first_operand", first_operand);
//        request.setAttribute("second_operand", second_operand);
//        request.setAttribute("operator", operator);
//        request.setAttribute("result_print",result);
//        request.getRequestDispatcher("result.jsp").forward(request,response);

    }
}
