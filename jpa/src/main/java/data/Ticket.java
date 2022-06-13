package data;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity
public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int lugar;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Trip trip;

    public Ticket() {
        super();
    }

    public Ticket(int lugar,Student student,Trip trip) {
        this.lugar = lugar;
        this.student = student;
        this.trip = trip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLugar(){
        return lugar;
    }
    public void setLugar(int lugar) {
        this.lugar = lugar;
    }

    public Trip getTrip(){
        return trip;
    }
    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Student getStudent(){
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

}