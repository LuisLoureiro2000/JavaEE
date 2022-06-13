package servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.IManageStudents;
import data.Student;

@WebServlet("/secured/Logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @EJB
    private IManageStudents manageStudents;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpSession session = httpReq.getSession(false);
        session.removeAttribute("auth");
        request.removeAttribute("auth");
        String destination = "/secured/logout.jsp";
        request.getRequestDispatcher(destination).forward(request, response);
    }
}