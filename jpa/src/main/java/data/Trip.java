package data;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.GregorianCalendar;

/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity
public class Trip implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String departure;
    private String destination;
    private int capacity;
    private float price;
    private String departureDate;
    private String departureHour;
    private int dateToCompare;

    @OneToMany(mappedBy="trip")
    private List<Ticket> tickets;


    public Trip() {
        super();
    }

    public Trip(String departure,String destination, String departureDate, String departureHour, int capacity, float price, int dateToCompare) {
        this.departure = departure;
        this.destination = destination;
        this.capacity = capacity;
        this.departure = departure;
        this.departureDate = departureDate;
        this.price = price;
        this.departureHour = departureHour;
        this.dateToCompare = dateToCompare;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureHour() {
        return departureHour;
    }

    public void setDepartureHour(String departureHour) {
        this.departureHour = departureHour;
    }

    public int getCapacity(){
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public float getPrice(){
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    public int getDateToCompare(){
        return dateToCompare;
    }
    public void setDateToCompare(int dateToCompare) {
        this.dateToCompare = dateToCompare;
    }

}