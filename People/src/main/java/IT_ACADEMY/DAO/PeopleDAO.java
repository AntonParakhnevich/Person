package IT_ACADEMY.DAO;

import IT_ACADEMY.Address;
import IT_ACADEMY.People;
import IT_ACADEMY.Util.HibernateSessionFactoryUtil;

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
        EntityManager entityManager = HibernateSessionFactoryUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(people);
        entityManager.getTransaction().commit();
    }

    @Override
    public People get(Serializable id) throws SQLException {
        EntityManager entityManager = HibernateSessionFactoryUtil.getEntityManager();
        entityManager.getTransaction().begin();
        People people = entityManager.find(People.class, id);
        entityManager.getTransaction().commit();
        return people;
    }

    @Override
    public void change(Serializable id, int value) throws SQLException {
        EntityManager entityManager = HibernateSessionFactoryUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        People people = entityManager.find(People.class, id);
        people.setAge(people.getAge() + value);
        entityManager.merge(people);
        transaction.commit();
    }

    @Override
    public int delete(Serializable id) throws SQLException {
        EntityManager entityManager = HibernateSessionFactoryUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(entityManager.find(People.class, id));
        transaction.commit();
        return 0;
    }


    @Override
    public void addAddress(int people_id, int address_id) throws SQLException {
        EntityManager entityManager = HibernateSessionFactoryUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        People people = entityManager.find(People.class, people_id);
        Address address = entityManager.find(Address.class, address_id);
        people.addAddress(address);
        transaction.commit();
    }

    public List<People> readDB() throws SQLException {
        EntityManager entityManager = HibernateSessionFactoryUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List resultList = entityManager.createNativeQuery("SELECT * FROM people;",People.class).getResultList();
        transaction.commit();
        return resultList;
    }


}
