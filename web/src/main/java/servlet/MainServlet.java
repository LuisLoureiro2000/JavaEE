package servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.IManageStudents;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import data.Student;
import org.apache.commons.codec.digest.DigestUtils;
@WebServlet("/main")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private IManageStudents manageStudents;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("email");
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpSession session = httpReq.getSession(false);
        String key = request.getParameter("key");
        String sha256hex = DigestUtils.sha256Hex(key);
        String destination = "/error.jsp";
        if (name != null && key != null) {
            String auth = manageStudents.login(name, sha256hex);
            if (auth.equals("")){
                request.getSession(true).removeAttribute("auth");
            } else {
                if(auth.split("--")[1].equals("M")){
                    request.setAttribute("auth", auth.split("--")[0]);
                    session.setAttribute("auth",auth.split("--")[0]);
                    session.setAttribute("error","");
                    destination = "/secured/welcomeManager.jsp";
                }
                else{
                    request.setAttribute("auth", auth.split("--")[0]);
                    session.setAttribute("auth",auth.split("--")[0]);
                    session.setAttribute("error","");
                    destination = "/secured/welcomeStudent.jsp";
                }
            }
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }
}