package book;
import java.sql.Time;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import beans.IManageStudents;
import data.Student;
@RequestScoped
@Path("/myservice")
@Produces(MediaType.APPLICATION_JSON)
public class MyService {
    @EJB
    private IManageStudents manageStudents;
    @GET
    @Path("/test")
    public String method1() {
        System.out.println("M1 executing....");
        return "M1 executed...";
    }
    @GET
    @Path("/CreateAccount")
    public String method2() {
        System.out.println("M2 executing....");
        String name = "Luis";
        String email = "Luis@hotmail.com";
        int age = 21;
        int phone = 961234567;
        String password = "Luispass";
        if(manageStudents.addStudent(name,email,password,phone,age,0) == 1){
            return "User " + name + " registered";
        }
        return "Já existe";
    }
    @GET
    @Path("/list")
    public List<Student> method3() {
        System.out.println("M3 executing....");
        List<Student> list = manageStudents.listStudents();
        return list;
    }
}