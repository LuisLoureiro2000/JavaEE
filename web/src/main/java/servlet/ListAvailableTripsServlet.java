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
import data.Trip;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import org.apache.commons.codec.digest.DigestUtils;
@WebServlet("/secured/ListAvailableTrips")
public class ListAvailableTripsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private IManageStudents manageStudents;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String current_date = String.valueOf(java.time.LocalDate.now());

        List<Trip> trip_list = manageStudents.listAvailableTrips(current_date);
        String to_send = "";
        for(int i=0; i < trip_list.size(); i++){
            to_send = to_send + "Trip ID: " + + trip_list.get(i).getId() + "\n";
            to_send = to_send + "Departure Point: " + trip_list.get(i).getDeparture() + "\n";
            to_send = to_send + "Destination: " + trip_list.get(i).getDestination() + "\n";
            to_send = to_send + "Departure Date: " + trip_list.get(i).getDepartureDate() + "\n";
            to_send = to_send + "Departure Hour: " + trip_list.get(i).getDepartureHour() + "\n";
            to_send = to_send + "Capacity: " + String.valueOf(trip_list.get(i).getCapacity()) + "\n";
            to_send = to_send + "Price: " + String.valueOf(trip_list.get(i).getPrice()) + "\n";
            to_send = to_send + "-----------" + "\n";
        }
        request.setAttribute("available_trips", to_send);

        String destinationPage = "/secured/ListAvailableTrips.jsp";
        request.getRequestDispatcher(destinationPage).forward(request, response);
    }
}