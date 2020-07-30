import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet_Currency_Converter", urlPatterns ="/currency-converter-index" )
public class Servlet_Currency_Converter extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rate = request.getParameter("rate");
        String usd = request.getParameter("usd");
        float vnd = Float.parseFloat(rate) * Float.parseFloat(usd);
//        request.setAttribute("rate", rate);
//        request.setAttribute("usd", usd);
//        request.setAttribute("vnd", vnd);
//        request.getRequestDispatcher("result.jsp").forward(request,response);

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Rate: " + rate + "</h1>");
        writer.println("<h1>USD: " + usd + "</h1>");
        writer.println("<h1>VND: " + vnd + "</h1>");
        writer.println("</html>");
    }
}
