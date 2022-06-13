package beans;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import data.Student;
import java.util.Calendar;
import java.util.Date;
import data.Manager;
import data.Trip;
import data.Ticket;
import java.time.LocalDate;
@Stateless
public class ManageStudents implements IManageStudents {
    @PersistenceContext(unitName = "playAula")
    EntityManager em;


    public int addStudent(String username, String email, String password, int phone, int age, int wallet) {
        String command = "select a from Student a where a.email=" + "'" + email + "' " + "or a.username=" + "'" + username + "'";
        List<Student> list = em.createQuery(command, Student.class).getResultList();
        System.out.println("Adding student " + username + "...");
        if (list.size() == 0) {
            Student s = new Student(username, email, password, phone, age, wallet, 0);
            em.persist(s);
            return 1;
        }
        return 0;
    }

    public List<Student> listStudents() {
        System.out.println("Retrieving students from the database...");
        List<Student> list = em.createQuery("select a from Student a", Student.class).getResultList();
        return list;
    }

    public String login(String email, String password) {
        List<Student> list = em.createQuery("select a from Student a where a.email=" + "'" + email + "' and a.password=" + "'" + password + "'", Student.class).getResultList();
        if (list.size() == 1) {
            return list.get(0).getUsername() + "--S";
        }
        List<Manager> list2 = em.createQuery("select a from Manager a where a.email=" + "'" + email + "' and a.password=" + "'" + password + "'", Manager.class).getResultList();
        if (list2.size() == 1) {
            return list2.get(0).getUsername() + "--M";
        }
        return "";
    }

    //Editar info de um user
    public int editUser(String field, String change, String username) {
        List<Student> list = em.createQuery("select a from Student a where a.username=" + "'" + username + "'", Student.class).getResultList();

        if (list.size() == 1) {
            if (field.equals("username") || field.equals("Username")) {
                list.get(0).setUsername(change);
            } else if (field.equals("email") || field.equals("Email")) {
                list.get(0).setEmail(change);
            } else if (field.equals("age") || field.equals("Age")) {
                list.get(0).setAge(Integer.parseInt(change));
            } else if (field.equals("phone") || field.equals("Phone")) {
                list.get(0).setPhone(Integer.parseInt(change));
            }
            else if (field.equals("password") || field.equals("Password")) {
                list.get(0).setPassword(change);
            }
            return 1;
        }
        return 0;

    }

    //Criar Trip
    public void CreateTrip(String departure,String destination,String departureDate, String departureHour, int capacity, float price){
        String full_date = "";
        full_date = departureDate.split("-")[0] + departureDate.split("-")[1] + departureDate.split("-")[2];
        int dateToCompare = Integer.parseInt(full_date);
        Trip t = new Trip(departure, destination, departureDate, departureHour, capacity, price, dateToCompare);
        em.persist(t);
    }

    //Listar Trips por data
    public List<Trip> SearchTripByDate(String searchDate){
        List<Trip> list = em.createQuery("select a from Trip a where a.departureDate='" + searchDate + "'", Trip.class).getResultList();
        return list;
    }

    //Wallet Functions
    public float getWallet(String username){
        List<Student> list = em.createQuery("select a from Student a where a.username=" + "'" + username + "'", Student.class).getResultList();
        if (list.size() == 1) {
            return list.get(0).getWallet();
        }
        return 0;
    }
    public float chargeWallet(String username,float value){
        List<Student> list = em.createQuery("select a from Student a where a.username=" + "'" + username + "'", Student.class).getResultList();
        if (list.size() == 1) {
            float aux = list.get(0).getWallet();
            aux = aux + value;
            list.get(0).setWallet(aux);
            return aux;
        }
        return 0;
    }

    //Ticket functions
    public String buyTicket(String username,String id, int place){
        List<Student> list = em.createQuery("select a from Student a where a.username=" + "'" + username + "'", Student.class).getResultList();
        List<Trip> list2 = em.createQuery("select a from Trip a where a.id=" + id, Trip.class).getResultList();
        if (list.size() == 1 && list2.size() == 1) {
            int usernameId = list.get(0).getId();
            int tripId = list2.get(0).getId();
            List<Ticket> list3 = em.createQuery("select a from Ticket a where a.trip=" +tripId + " and a.lugar=" +place, Ticket.class).getResultList();
            if(list3.size() == 0){
                List<Ticket> list4 = em.createQuery("select a from Ticket a where a.student=" +usernameId + " and a.trip=" +tripId, Ticket.class).getResultList();
                if(list4.size() > 0){
                    return "you are already in this trip-";
                }
                list4 = em.createQuery("select a from Ticket a where a.trip=" +tripId, Ticket.class).getResultList();
                if(list4.size() >= list2.get(0).getCapacity()){
                    return "This trip is full-";
                }
                if(list2.get(0).getCapacity() < place){
                    return "Out of Capacity-";
                }
                if (list.get(0).getWallet() > list2.get(0).getPrice()){
                    float aux= list.get(0).getWallet();
                    int aux2= list.get(0).getCounter();
                    aux = aux - list2.get(0).getPrice();
                    aux2 = aux2 + 1;
                    list.get(0).setWallet(aux);
                    list.get(0).setCounter(aux2);
                    Ticket t = new Ticket(place,list.get(0),list2.get(0));
                    em.persist(t);
                    return "success-" + String.valueOf(aux);
                }
                else{
                    return "No money-";
                }
            }
            else{
                return "place already taken-";
            }
        }
        return "trip doesnt exist-";
    }
    public String removeTicket(String username,String id, int place){
        List<Student> list = em.createQuery("select a from Student a where a.username=" + "'" + username + "'", Student.class).getResultList();
        List<Trip> list2 = em.createQuery("select a from Trip a where a.id=" + id, Trip.class).getResultList();
        if (list.size() == 1 && list2.size() == 1) {
            int usernameId = list.get(0).getId();
            int tripId = list2.get(0).getId();
            List<Ticket> list3 = em.createQuery("select a from Ticket a where a.student=" + usernameId + " and a.trip=" +tripId + " and a.lugar=" +place, Ticket.class).getResultList();
            if(list3.size() == 1){
                float aux= list.get(0).getWallet();
                aux = aux + list2.get(0).getPrice();
                list.get(0).setWallet(aux);
                list.get(0).setCounter(list.get(0).getCounter()-1);
                em.remove(list3.get(0));
                return "success-" + String.valueOf(aux);
            }
            else{
                return "you are not even in this trip xD-";
            }
        }
        return "trip doesnt exist-";
    }

    //listar as trips de um user
    public List<Trip> listTrips(String username) {
        List<Trip> finalList = new ArrayList<Trip>();
        String tripId = "";
        System.out.println("Retrieving students from the database...");
        List<Student> list = em.createQuery("select a from Student a where a.username=" + "'" + username + "'", Student.class).getResultList();
        List<Ticket> list2 = em.createQuery("select a from Ticket a where a.student=" + list.get(0).getId(), Ticket.class).getResultList();
        for(int i=0;i<list2.size();i++){
            tripId = String.valueOf(list2.get(i).getTrip().getId());
            List<Trip> list3 = em.createQuery("select a from Trip a where a.id=" + tripId, Trip.class).getResultList();
            finalList.add(list3.get(0));
        }
        return finalList;
    }

    //listar todas as trips (para users)
    public List<Trip> listAvailableTrips(String current_date){
        int current_date_int = Integer.parseInt(current_date.split("-")[0] + current_date.split("-")[1] + current_date.split("-")[2]);
        List<Trip> list = em.createQuery("select a from Trip a where a.dateToCompare>" + current_date_int, Trip.class).getResultList();
        return list;
    }

    //listar todas as trips entre intervalos de tempo (managers)
    public List<Trip> SearchTripByInterval(String date1, String date2){
        int date1_int = Integer.parseInt(date1.split("-")[0] + date1.split("-")[1] + date1.split("-")[2]);
        int date2_int = Integer.parseInt(date2.split("-")[0] + date2.split("-")[1] + date2.split("-")[2]);
        List<Trip> list = new ArrayList<Trip>();

        if(date2_int > date1_int)
            list = em.createQuery("select a from Trip a where a.dateToCompare>" + date1_int + " AND a.dateToCompare<" + date2_int, Trip.class).getResultList();
        else{
            list = em.createQuery("select a from Trip a where a.dateToCompare>" + date2_int + " AND a.dateToCompare<" + date1_int, Trip.class).getResultList();
        }
        return list;
    }

    //listar todos os students numa certa trip
    public List<Student> ListStudentsInTrips(Trip trip){
        List<Ticket> tickets = em.createQuery("select a from Ticket a where a.trip=" + trip.getId(), Ticket.class).getResultList();
        List<Student> passengers = new ArrayList<Student>();

        for(int i=0; i<tickets.size(); i++){
            passengers.add(tickets.get(i).getStudent());
        }

        return passengers;
    }

    public int DeleteTrip(String tripid){
        float aux = 0;
        List<Student> list = new ArrayList<Student>();
        List<Trip> list2 = em.createQuery("select a from Trip a where a.id=" + tripid, Trip.class).getResultList();
        if(list2.size() > 0) {
            int tripId = list2.get(0).getId();
            List<Ticket> list3 = em.createQuery("select a from Ticket a where a.trip=" + tripid, Ticket.class).getResultList();

            for (int i = 0; i < list3.size(); i++) {
                list = em.createQuery("select a from Student a where a.id=" + list3.get(i).getStudent().getId(), Student.class).getResultList();
                aux = list.get(0).getWallet();
                aux = aux + list2.get(0).getPrice();
                list.get(0).setWallet(aux);
                em.remove(list3.get(i));
            }
            em.remove(list2.get(0));
        }
        else{
            return 1;
        }

        return 0;
    }

    public List<Student> topFive() {
        System.out.println("Retrieving students from the database...");
        List<Ticket> old_tickets = new ArrayList<Ticket>();
        Student aux = new Student();
        int aux2 = 0;
        List<Integer> count = new ArrayList<Integer>();
        List<Student> list = em.createQuery("select a from Student a", Student.class).getResultList();
        for(int i=0;i<list.size();i++){
            count.add(0);
        }

        String current_date = String.valueOf(java.time.LocalDate.now());
        int current_date_int = Integer.parseInt(current_date.split("-")[0] + current_date.split("-")[1] + current_date.split("-")[2]);
        List<Trip> list2 = em.createQuery("select a from Trip a where a.dateToCompare<" + current_date_int, Trip.class).getResultList();

        for(int i=0;i<list2.size();i++){
            List<Ticket> list3 = em.createQuery("select a from Ticket a where a.trip=" + list2.get(i).getId(), Ticket.class).getResultList();
            for(int j=0;j<list3.size();j++){
                old_tickets.add(list3.get(j));
            }
        }

        for(int i=0;i<list.size();i++){
            for(int j=0;j<old_tickets.size();j++){
                if(old_tickets.get(j).getStudent().getId() == list.get(i).getId()){
                    count.set(i,count.get(i)+1);
                }
            }
        }

        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.size()-i-1;j++){
                if(count.get(j) < count.get(j+1)){
                    aux2 = count.get(j);
                    aux = list.get(j);
                    count.set(j,count.get(j+1));
                    count.set(j+1,aux2);
                    list.set(j,list.get(j+1));
                    list.set(j+1,aux);
                }
            }
        }
        return list;
    }

    public List<Integer> topFiveCount() {
        System.out.println("Retrieving students from the database...");
        List<Ticket> old_tickets = new ArrayList<Ticket>();
        Student aux = new Student();
        int aux2 = 0;
        List<Integer> count = new ArrayList<Integer>();
        List<Student> list = em.createQuery("select a from Student a", Student.class).getResultList();
        for(int i=0;i<list.size();i++){
            count.add(0);
        }

        String current_date = String.valueOf(java.time.LocalDate.now());
        int current_date_int = Integer.parseInt(current_date.split("-")[0] + current_date.split("-")[1] + current_date.split("-")[2]);
        List<Trip> list2 = em.createQuery("select a from Trip a where a.dateToCompare<" + current_date_int, Trip.class).getResultList();

        for(int i=0;i<list2.size();i++){
            List<Ticket> list3 = em.createQuery("select a from Ticket a where a.trip=" + list2.get(i).getId(), Ticket.class).getResultList();
            for(int j=0;j<list3.size();j++){
                old_tickets.add(list3.get(j));
            }
        }

        for(int i=0;i<list.size();i++){
            for(int j=0;j<old_tickets.size();j++){
                if(old_tickets.get(j).getStudent().getId() == list.get(i).getId()){
                    count.set(i,count.get(i)+1);
                }
            }
        }

        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.size()-i-1;j++){
                if(count.get(j) < count.get(j+1)){
                    aux2 = count.get(j);
                    aux = list.get(j);
                    count.set(j,count.get(j+1));
                    count.set(j+1,aux2);
                    list.set(j,list.get(j+1));
                    list.set(j+1,aux);
                }
            }
        }
        return count;
    }

}
