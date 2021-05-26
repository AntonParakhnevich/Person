package IT_ACADEMY.Util;

import IT_ACADEMY.Address;
import IT_ACADEMY.People;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by .
 */
public class HibernateSessionFactoryUtil {
//    private static SessionFactory sessionFactory;
//
//    public HibernateSessionFactoryUtil() {
//    }
//
//    public static SessionFactory getSessionFactory() {
//        if (sessionFactory == null) {
//            Configuration configuration = new Configuration();
//
//            configuration.addAnnotatedClass(People.class);
//            configuration.addAnnotatedClass(Address.class);
//            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
//            sessionFactory = configuration.buildSessionFactory(builder.build());
//        }
//        return sessionFactory;
//    }

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("ITAcademy");

    public static EntityManager getEntityManager() {
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }

    public static void close() {
        ENTITY_MANAGER_FACTORY.close();
    }
}
