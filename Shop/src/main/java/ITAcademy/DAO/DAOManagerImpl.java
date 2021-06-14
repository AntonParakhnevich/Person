package ITAcademy.DAO;

import ITAcademy.Entity.Manager;
import ITAcademy.Util.SessionUtil;
import org.hibernate.Session;

import java.io.Serializable;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by .
 */
public class DAOManagerImpl implements DAOManager {
    Session session;
    public DAOManagerImpl(Session session) {
        this.session=session;
    }

    @Override
    public void save(Manager manager) throws SQLException {
        session.getTransaction().begin();
        session.save(manager);
        session.getTransaction().commit();
    }

    @Override
    public Manager get(Serializable id) throws SQLException {
        Manager manager = new Manager();
        manager = session.get(Manager.class, id);
        session.getTransaction().commit();
        return manager;
    }

    @Override
    public void delete(Serializable id) throws SQLException {
        session.getTransaction().begin();
        Manager manager = session.get(Manager.class, id);
        session.delete(manager);
        session.getTransaction().commit();
    }

    @Override
    public List<Manager> readDB() throws SQLException {
        List<Manager> managers = new ArrayList<>();
        session.getTransaction().begin();
        managers = session.createQuery("SELECT m FROM Manager m", Manager.class).list();
        session.getTransaction().commit();
        return managers;
    }

    @Override
    public List<Manager> managers(String jpql) throws SQLException {
        List<Manager> managers = new ArrayList<>();
        session.getTransaction().begin();
        managers = session.createQuery(jpql, Manager.class).list();
        session.getTransaction().commit();
        return managers;
    }

    @Override
    public List<Manager> managersCriterionData(String jpql, LocalDateTime localDateTime) throws SQLException {
        List<Manager> managers=new ArrayList<>();
        session.getTransaction().begin();
        managers=session.createQuery(jpql).setParameter("data",localDateTime).list();
        session.getTransaction().commit();
        return managers;
    }


}
