package servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.IManageStudents;
import data.Student;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.codec.digest.DigestUtils;

@WebServlet("/secured/CreateTrip")
public class CreateTripServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private IManageStudents manageStudents;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String departure = request.getParameter("departure");
        String destination = request.getParameter("destination");
        String departureDate = request.getParameter("departureDate");

        String departureHour = request.getParameter("departureHour");
        int capacity = Integer.parseInt(request.getParameter("capacity"));
        float price = Float.parseFloat(request.getParameter("price"));
        manageStudents.CreateTrip(departure,destination,departureDate,departureHour,capacity,price);
        String destinationPage = "/secured/indexManager.jsp";
        request.getRequestDispatcher(destinationPage).forward(request, response);
    }
}