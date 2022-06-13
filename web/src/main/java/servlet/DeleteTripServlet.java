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

@WebServlet("/secured/DeleteTrip")
public class DeleteTripServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private IManageStudents manageStudents;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idtrip = request.getParameter("tripId");
        String destinationPage = "/secured/indexManager.jsp";
        if(manageStudents.DeleteTrip(idtrip) == 1){
            request.setAttribute("warning", "this trip does not exist");
            destinationPage = "/secured/DeleteTrip.jsp";
        };
        request.getRequestDispatcher(destinationPage).forward(request, response);
    }
}
