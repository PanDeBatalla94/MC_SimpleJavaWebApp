import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Marek on 13/04/2017.
 */
@WebServlet(name = "CounterViewServlet")
public class CounterViewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer counter = (Integer) getServletContext().getAttribute("counter");
        if (counter == null) counter = 0;

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter writer = response.getWriter()) {

            writer.println(getDocType());
            writer.println("<head>");
            writer.println("<meta charset=\"UTF-8\" />");
            writer.println(getTitle());
            writer.println("</head>");
            writer.println("<body>");

            writer.println(getVisitors());

            writer.println("<h1>" + counter + "</h1>");

            writer.println("</body>");
            writer.println("</html>");
        }
    }
    public String getTitle() {
        return "<title>CounterViewServlet using doGet() to view counter value</title>";
    }
    public String getVisitors() {
        return "<h1>Total number of visitors is </h1>";
    }
    public String getDocType() {
        return "<!DOCTYPE html><html>";
    }
}
