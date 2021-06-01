package IT_ACADEMY.DAO;

import IT_ACADEMY.Address;
import IT_ACADEMY.Util.HibernateSessionFactoryUtil;

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
        EntityManager entityManager = HibernateSessionFactoryUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(address);
        transaction.commit();
    }

    @Override
    public Address get(Serializable id) throws SQLException {
        EntityManager entityManager = HibernateSessionFactoryUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Address address = entityManager.find(Address.class, id);
        transaction.commit();
        return address;
    }

    @Override
    public void change(Serializable id, int value) throws SQLException {
        EntityManager entityManager = HibernateSessionFactoryUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Address address = entityManager.find(Address.class, id);
        address.setHouse(address.getHouse() + value);
        entityManager.merge(address);
        transaction.commit();
    }

    @Override
    public int delete(Serializable id) throws SQLException {
        EntityManager entityManager = HibernateSessionFactoryUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(entityManager.find(Address.class, id));
        transaction.commit();
        return 0;
    }

    public List<Address> readDB() throws SQLException {
        EntityManager entityManager = HibernateSessionFactoryUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List addresses = entityManager.createNativeQuery("SELECT * FROM address", Address.class).getResultList();
        transaction.commit();
        return addresses;
    }
}
