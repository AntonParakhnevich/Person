package ITAcademy.Service;

import ITAcademy.DAO.DAOManagerImpl;
import ITAcademy.Entity.Manager;
import org.hibernate.Session;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

/**
 * Created by .
 */
public class ServiceManager {

    DAOManagerImpl daoManager ;
    private LocalDateTime dataCriterion = LocalDateTime.of(2020, Month.JANUARY, 10,10,20);


    public ServiceManager(Session session) {
        daoManager=new DAOManagerImpl(session);
    }

    public void printAllManagers() {
        try {
            List<Manager> managers = daoManager.readDB();
            System.out.println("Managers : ");
            for (Manager m : managers) {
                System.out.println(m);
            }
            System.out.println();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void printManagersCriterionProceeds() {
        try {
            List<Manager> managers = daoManager.managers("SELECT m FROM Manager m where m.shop.proceeds>10000");
            System.out.println("Managers working in shops where proceeds > 10000");
            for (Manager m : managers) {
                System.out.println(m.getLastName() + " " + m.getFirstName() + " " + m.getSurname());
            }
            System.out.println();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void save(Manager manager){
        try {
            daoManager.save(manager);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void printLastNameAndSalary(){
        try {
            List<Manager> managers = daoManager.managersCriterionData("SELECT m FROM Manager m where m.shop.date<:data", dataCriterion);
            for (Manager m:managers){
                System.out.println(m.getLastName()+" "+m.getSalary());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
