package IT_ACADEMY.DAO;

import IT_ACADEMY.Entity.Address;
import IT_ACADEMY.Entity.People;
import IT_ACADEMY.Util.HibernateSessionFactoryUtil;
import IT_ACADEMY.Util.SessionUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by .
 */
public class PeopleDAO implements DAOPeople {
    private String URL;
    private String USER;
    private String PASSWORD;

    public PeopleDAO(String URL, String USER, String PASSWORD) {
        this.URL = URL;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
    }

    @Override
    public void save(People people) throws SQLException {
        Session session = SessionUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.save(people);
        session.getTransaction().commit();
    }

    @Override
    public People get(Serializable id) throws SQLException {
        Session session = SessionUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        People people = session.get(People.class, id);
        session.getTransaction().commit();
        return people;
    }

    @Override
    public void change(Serializable id, int value) throws SQLException {
        Session session = SessionUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        People people = session.get(People.class, id);
        people.setAge(people.getAge()+value);
        session.update(people);
        session.getTransaction().commit();
    }

    @Override
    public int delete(Serializable id) throws SQLException {
        Session session = SessionUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(session.get(People.class,id));
        session.getTransaction().commit();
        return 0;
    }

    @Override
    public void addAddress(int people_id, int address_id) throws SQLException {
        Session session = SessionUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        People people = session.find(People.class, people_id);
        Address address = session.find(Address.class, address_id);
        people.addAddress(address);
        session.getTransaction().commit();
    }

    public List<People> readDB() throws SQLException {
        Session session = SessionUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        List resultList = session.createNativeQuery("SELECT * FROM people;",People.class).getResultList();
        return resultList;
    }


}
