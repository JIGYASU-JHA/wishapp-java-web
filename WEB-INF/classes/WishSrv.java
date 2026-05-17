import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.time.LocalTime;

public class WishSrv extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        LocalTime time = LocalTime.now();
        int hour = time.getHour();

        String message = "";
        String image = "";

        if(hour < 12) {
            message = "Good Morning";
            image = "Daily Positive Affirmations.jpeg";
        }
        else if(hour < 16) {
            message = "Good Afternoon";
            image = "good-afternoon-greetings.jpg";
        }
        else if(hour < 20) {
            message = "Good Evening";
            image = "good-evening-wishes.jpg";
        }
        else {
            message = "Good Night";
            image = "download4.jpeg";
        }

        out.println("<html><body>");
        out.println("<h2>" + message + "</h2>");
        out.println("<img src='" + request.getContextPath() + "/" + image + "' width='600' height='800'>");
        out.println("</body></html>");

        out.close();
    }
}
  

