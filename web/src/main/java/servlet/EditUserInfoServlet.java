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

@WebServlet("/secured/EditUserInfo")
public class EditUserInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @EJB
    private IManageStudents manageStudents;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String field = request.getParameter("field");
        String change = request.getParameter("change");
        String destination = "/error.jsp";
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpSession session = httpReq.getSession(false);
        String username = (String)session.getAttribute("auth");
        if (field != null && change != null) {
            if(field.equals("password") || field.equals("Password")){
                change = DigestUtils.sha256Hex(change);
            }
            int success = manageStudents.editUser(field, change, username);
            if (success==1) {
                request.setAttribute("auth", username);
                destination = "/secured/indexStudent.jsp";
            }
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }
}