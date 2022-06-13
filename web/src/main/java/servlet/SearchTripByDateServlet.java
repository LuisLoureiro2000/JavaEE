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
import org.apache.commons.codec.digest.DigestUtils;
@WebServlet("/secured/SearchTripByDate")
public class SearchTripByDateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private IManageStudents manageStudents;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String searchDate = request.getParameter("searchDate");
        String dropValue = request.getParameter("showPassengers");

        String to_send = "";

        if(searchDate.equals("")){
            to_send = "You need to choose a date first!";
        }
        else {
            List<Trip> trip_list = manageStudents.SearchTripByDate(searchDate);
            for (int i = 0; i < trip_list.size(); i++) {
                if (dropValue.equals("1")) {
                    to_send = to_send + "Trip ID: " + +trip_list.get(i).getId() + "\n";
                    to_send = to_send + "Departure Point: " + trip_list.get(i).getDeparture() + "\n";
                    to_send = to_send + "Destination: " + trip_list.get(i).getDestination() + "\n";
                    to_send = to_send + "Departure Date: " + trip_list.get(i).getDepartureDate() + "\n";
                    to_send = to_send + "Departure Hour: " + trip_list.get(i).getDepartureHour() + "\n";
                    to_send = to_send + "Capacity: " + String.valueOf(trip_list.get(i).getCapacity()) + "\n";
                    to_send = to_send + "Price: " + String.valueOf(trip_list.get(i).getPrice()) + "\n";
                    to_send = to_send + "-----------" + "\n";
                } else if (dropValue.equals("2")) {
                    to_send = to_send + "Trip ID: " + trip_list.get(i).getId() + "\n";
                    List<Student> passenger_list = manageStudents.ListStudentsInTrips(trip_list.get(i));
                    for (int j = 0; j < passenger_list.size(); j++) {
                        to_send = to_send + "Passenger " + String.valueOf(j) + ": Username=" + passenger_list.get(j).getUsername() + " ID=" + passenger_list.get(j).getId() + "\n";
                    }
                    to_send = to_send + "-----------" + "\n";
                }

            }
        }
        request.setAttribute("trip_list", to_send);

        String destinationPage = "/secured/SearchTripByDate.jsp";
        request.getRequestDispatcher(destinationPage).forward(request, response);
    }
}