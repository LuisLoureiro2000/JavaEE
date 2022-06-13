package servlet;
import org.apache.commons.codec.digest.DigestUtils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import beans.IManageStudents;
import data.Student;

@WebServlet("/secured/RemoveTicket")
public class RemoveTicket extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @EJB
    private IManageStudents manageStudents;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String field = request.getParameter("trip");
        String place = request.getParameter("place");
        String destination = "/secured/RemoveTicket.jsp";
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpSession session = httpReq.getSession(false);
        String username = (String)session.getAttribute("auth");
        String value = manageStudents.removeTicket(username,field,Integer.parseInt(place));
        if(value.split("-")[0].equals("success")){
            request.setAttribute("auth", username);
            session.setAttribute("Wallet",value.split("-")[1]);
            destination = "/secured/indexStudent.jsp";
            session.setAttribute("error","");
        }
        else{
            session.setAttribute("error",value.split("-")[0]);
        }

        request.getRequestDispatcher(destination).forward(request, response);
    }
}