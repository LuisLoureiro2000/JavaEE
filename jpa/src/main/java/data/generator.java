package data;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import data.Student;
import data.Manager;
public class generator {
    public static Date getDate(int day, int month, int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, day);
        Date d = cal.getTime();
        return d;
    }
    public static void main(String[] args) {
        Manager manager1= new Manager("Carlos", "Carlos@hotmail.com", "12345",1,1,0);
        Manager manager2= new Manager("Carlos2", "Carlos2@hotmail.com", "12345",1,1,0);
        Manager manager3= new Manager("Carlos3", "Carlos3@hotmail.com", "12345",1,1,0);
        Manager[] managers = {manager1,manager2,manager3};
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Managers");
        EntityManager em = emf.createEntityManager();
        EntityTransaction trx = em.getTransaction();
        trx.begin();
        for (Manager m : managers)
        {
            em.persist(m);
        }
        trx.commit();
        em.close();
        emf.close();
    }
}