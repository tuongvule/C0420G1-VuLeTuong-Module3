import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet", urlPatterns = "/duong_dan_ung_dung_tinh_chiet_khau_sp")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gia_niem_yet = request.getParameter("gia_niem_yet");
        String ti_le_chiet_khau = request.getParameter("ti_le_chiet_khau");
        double amount = Double.parseDouble(gia_niem_yet)* Double.parseDouble(ti_le_chiet_khau) * 0.01;
        double gia_sau_chiet_khau = Double.parseDouble(gia_niem_yet) + amount;
        request.setAttribute("gia_sau_chiet_khau", gia_sau_chiet_khau);
        request.setAttribute("amount", amount);
        request.getRequestDispatcher("ketqua.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
