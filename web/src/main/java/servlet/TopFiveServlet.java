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
@WebServlet("/secured/TopFive")
public class TopFiveServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @EJB
    private IManageStudents manageStudents;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String destination = "/error.jsp";
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpSession session = httpReq.getSession(false);
        String username = (String) session.getAttribute("auth");


        List<Student> field1List = manageStudents.topFive();
        List<Integer> intlist = manageStudents.topFiveCount();
        String result = "";
        if (field1List.size() <= 5) {
            for (int i = 0; i < field1List.size(); i++) {
                result = result + String.valueOf(i+1) + ". ID: " + String.valueOf(field1List.get(i).getId()) + " ";
                result = result + "Username: " + String.valueOf(field1List.get(i).getUsername()) + " ";
                result = result + "Number of Trips: " + String.valueOf(intlist.get(i)) + "\n";
            }
        }
        else{
            for (int i = 0; i < 5; i++) {
                result = result + String.valueOf(i+1) + ". ID: " + String.valueOf(field1List.get(i).getId()) + " ";
                result = result + "Username: " + String.valueOf(field1List.get(i).getUsername()) + " ";
                result = result + "Number of Trips: " + String.valueOf(intlist.get(i)) + "\n";
            }
        }

        request.setAttribute("passengers", result);
        request.getRequestDispatcher("/secured/TopFive.jsp").forward(request, response);

    }
}