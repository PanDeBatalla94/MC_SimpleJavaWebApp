import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Marek on 13/04/2017.
 */
@WebServlet(name = "SimpleServlet")
public class SimpleServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter writer = response.getWriter()) {

            writer.println(getDocType());
            writer.println("<head>");
            writer.println("<meta charset=\"UTF-8\" />");
            writer.println(getTitle());
            writer.println("</head>");
            writer.println("<body>");

            writer.println("<h1>This is a simple java servlet.</h1>");
            writer.println("<h2>" + getYear() + "</h2>");
            writer.println("</body>");
            writer.println("</html>");
        }
    }

    public String getTitle() {
        return "<title>SimpleServlet using doGet() to generate simple website</title>";
    }
    public String getDocType() {
        return "<!DOCTYPE html><html>";
    }
    public String getYear() {
        return "2018";
    }
}
