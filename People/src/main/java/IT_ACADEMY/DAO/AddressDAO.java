package IT_ACADEMY.DAO;

import IT_ACADEMY.Entity.Address;
import IT_ACADEMY.Util.HibernateSessionFactoryUtil;
import IT_ACADEMY.Util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by .
 */
public class AddressDAO implements DAOAddress {
    private String URL;
    private String USER;
    private String PASSWORD;

    public AddressDAO(String URL, String USER, String PASSWORD) {
        this.URL = URL;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
    }

    public void save(Address address) throws SQLException {
        Session session = SessionUtil.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.save(address);
        transaction.commit();
    }

    @Override
    public Address get(Serializable id) throws SQLException {
        Session session = SessionUtil.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Address address = session.get(Address.class, id);
        transaction.commit();
        return address;
    }

    @Override
    public void change(Serializable id, int value) throws SQLException {
        Session session = SessionUtil.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Address address = session.get(Address.class, id);
        address.setHouse(address.getHouse()+value);
        session.update(address);
        transaction.commit();
    }

    @Override
    public int delete(Serializable id) throws SQLException {
        Session session = SessionUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(session.get(Address.class,id));
        session.getTransaction().commit();
        return 0;
    }

    public List<Address> readDB() throws SQLException {
        Session session = SessionUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        List<Address> addresses = session.createNativeQuery("SELECT * FROM address", Address.class).getResultList();
        session.getTransaction().commit();
        return addresses;
    }

}
