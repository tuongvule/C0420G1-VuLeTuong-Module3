import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Servlet_Translate", urlPatterns = "/translate")
public class Servlet_Translate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map <String, String> dictionary = new HashMap<>();
        dictionary.put("spring", "Mùa xuân");
        dictionary.put("summer", "Mùa hạ");
        dictionary.put("autumn", "Mùa thu");
        dictionary.put("winter", "Mùa đông");
        dictionary.put("january", "Tháng một");
        dictionary.put("february", "Tháng hai");
        dictionary.put("march", "Tháng ba");
        dictionary.put("april", "Tháng tư");
        dictionary.put("may", "Tháng năm");
        dictionary.put("june", "Tháng sáu");
        dictionary.put("july", "Tháng bảy");
        dictionary.put("august", "Tháng tám");
        dictionary.put("september", "Tháng chín");
        dictionary.put("october", "Tháng mười");
        dictionary.put("november", "Tháng mười một");
        dictionary.put("december", "Tháng mười hai");

        String key_word = request.getParameter("key_word");

        PrintWriter writer = response.getWriter();
        writer.println("<html>");

        String result = dictionary.get(key_word);

        if (result != null){
            writer.println("Word: " + key_word);
            writer.println("Result: " + result);
        }else {
            writer.println("Not found.");
        }
        writer.println("</html>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
