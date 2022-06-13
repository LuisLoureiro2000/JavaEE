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
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.digest.DigestUtils;

@WebServlet("/CreateAccount")
public class CreateAccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @EJB
    private IManageStudents manageStudents;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpSession session = httpReq.getSession(false);
        String username = request.getParameter("username");
        String key = request.getParameter("key");
        int wallet = Integer.parseInt(request.getParameter("wallet"));
        String sha256hex = DigestUtils.sha256Hex(key);
        int phone = Integer.parseInt(request.getParameter("phone"));
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        String destination = "/web/error.jsp";

        if (username != null && key != null) {
            int auth = manageStudents.addStudent(username,email,sha256hex,phone,age,wallet);
            if (auth==1) {
                request.setAttribute("auth", username);
                destination = "/secured/welcomeStudent.jsp";
                session.setAttribute("error","");
                session.setAttribute("auth",username);
            } else {
                request.getSession(true).removeAttribute("auth");
            }
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }
}