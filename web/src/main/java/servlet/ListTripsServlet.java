package servlet;
import org.apache.commons.codec.digest.DigestUtils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.IManageStudents;
import data.Student;
import java.util.List;
import javax.servlet.http.HttpSession;
import java.util.stream.Collectors;
import data.Trip;
@WebServlet("/secured/ListTrips")
public class ListTripsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @EJB
    private IManageStudents manageStudents;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String destination = "/error.jsp";
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpSession session = httpReq.getSession(false);
        String username = (String)session.getAttribute("auth");

        List<Trip> field1List = manageStudents.listTrips(username);
        String result = "";
        for (int i=0;i<field1List.size();i++){
            {
                result = result + "Trip Number: " + String.valueOf(field1List.get(i).getId()) + "\n";
                result = result + "Departure: " + String.valueOf(field1List.get(i).getDeparture()) + " ";
                result = result + "Destination: " + String.valueOf(field1List.get(i).getDestination()) + " ";
                result = result + "Departure Date: " + String.valueOf(field1List.get(i).getDepartureDate()) + " ";
                result = result + "Price: " + String.valueOf(field1List.get(i).getPrice()) + " ";
                result = result + "Capacity: " + String.valueOf(field1List.get(i).getCapacity()) + "\n";
            }
        }
        request.setAttribute("trips",result);
        request.getRequestDispatcher("/secured/ShowTrips.jsp").forward(request, response);
    }

}