package ITAcademy.Util;

import ITAcademy.Entity.Address;
import ITAcademy.Entity.Manager;
import ITAcademy.Entity.Shop;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by .
 */
public class SessionUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSession() {
        if (sessionFactory == null) {
            try {
                Configuration configure = new Configuration().configure();
                configure.addAnnotatedClass(Shop.class);
                configure.addAnnotatedClass(Address.class);
                configure.addAnnotatedClass(Manager.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configure.getProperties());
                sessionFactory = configure.buildSessionFactory(builder.build());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static void close() {
        sessionFactory.close();
    }
}
