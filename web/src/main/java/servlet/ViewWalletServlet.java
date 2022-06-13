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

@WebServlet("/secured/ViewWallet")
public class ViewWalletServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @EJB
    private IManageStudents manageStudents;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String destination = "/error.jsp";
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpSession session = httpReq.getSession(false);
        String username = (String)session.getAttribute("auth");
        float value = manageStudents.getWallet(username);
        request.setAttribute("auth", username);
        session.setAttribute("Wallet",String.valueOf(value));
        destination = "/secured/ViewWallet.jsp";

        request.getRequestDispatcher(destination).forward(request, response);
    }
}