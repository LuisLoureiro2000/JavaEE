package data;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity
public class Manager implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String email;
    private int phone;
    private int age;
    private int logging;
    private String password;

    public Manager() {
        super();
    }

    public Manager(String username,String email,String password, int phone,int age,int logging) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.age = age;
        this.logging = logging;
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
    public int getLogging() {
        return logging;
    }

    public void setLogging(int logging) {
        this.logging = logging;
    }
}