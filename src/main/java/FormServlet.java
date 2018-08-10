import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Marek on 13/04/2017.
 */
@WebServlet(name = "FormServlet")
public class FormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter writer = response.getWriter()) {

            writer.println(getDocType());
            writer.println("<head>");
            writer.println("<meta charset=\"UTF-8\" />");
            writer.println(getTitle());
            writer.println("</head>");
            writer.println("<body>");

            writer.println("<h1>Hi " +
                    request.getParameter("first_name") +
                    " " +
                    request.getParameter("last_name") +
                    "! Nice to meet you ;)</h1>");
            writer.println("<h2>" + getYear() + "</h2>");

            writer.println("</body>");
            writer.println("</html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public String getTitle() {
        return "<title>FormServlet using doGet() to read form data</title>";
    }
    public String getDocType() {
        return "<!DOCTYPE html><html>";
    }
    public String getYear() {
        return "2018";
    }
}
