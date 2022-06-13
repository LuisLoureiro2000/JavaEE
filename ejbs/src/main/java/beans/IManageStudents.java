package beans;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import data.Student;
import data.Trip;
import java.util.Calendar;
import java.util.Date;
@Stateless
public interface IManageStudents{
    @PersistenceContext(unitName = "playAula")
    public int addStudent(String username,String email,String password, int phone,int age,int wallet);
    public List<Student> listStudents();
    public String login(String email, String password);
    public int editUser(String field, String change, String username);
    public float getWallet(String username);
    public float chargeWallet(String username,float value);
    public String buyTicket(String username,String id, int place);
    public String removeTicket(String username,String id, int place);
    public List<Trip> listTrips(String username);
    public void CreateTrip(String departure,String destination,String departureDate,String departureHour,int capacity,float price);
    public List<Trip> SearchTripByDate(String searchDate);
    public List<Trip> listAvailableTrips(String current_date);
    public List<Trip> SearchTripByInterval(String date1, String date2);
    public List<Student> ListStudentsInTrips(Trip trip);
    public int DeleteTrip(String tripid);
    public List<Student> topFive();
    public List<Integer> topFiveCount();
}