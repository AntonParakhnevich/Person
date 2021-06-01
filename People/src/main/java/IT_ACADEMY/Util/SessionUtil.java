package IT_ACADEMY.Util;

import IT_ACADEMY.Entity.Address;
import IT_ACADEMY.Entity.People;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


/**
 * Created by .
 */
public class SessionUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configure = new Configuration().configure();
                configure.addAnnotatedClass(Address.class);
                configure.addAnnotatedClass(People.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configure.getProperties());
                sessionFactory = configure.buildSessionFactory(builder.build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static void close(){
        sessionFactory.close();
    }
}
