package data;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String email;
    private int phone;
    private int age;
    private float wallet;
    private String password;
    private int counter;

    @OneToMany(mappedBy="student")
    private List<Ticket> tickets;

    public Student() {
        super();
    }

    public Student(String username,String email,String password, int phone,int age,float wallet,int counter) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.age = age;
        this.wallet = wallet;
        this.counter = counter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public float getWallet() {
        return wallet;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
    public int getCounter() {
        return counter;
    }
}