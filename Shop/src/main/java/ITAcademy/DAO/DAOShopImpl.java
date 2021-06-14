package ITAcademy.DAO;

import ITAcademy.Entity.Shop;
import ITAcademy.Util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by .
 */
public class DAOShopImpl implements DAOShop {
    Session session;

    public DAOShopImpl(Session session) {
        this.session = session;
    }

    @Override
    public void save(Object o) throws SQLException {
        session.getTransaction().begin();
        session.save(o);
        session.getTransaction().commit();
    }

    @Override
    public Object get(Serializable id) throws SQLException {
        Shop shop = new Shop();
        session.getTransaction().begin();
        shop = session.get(Shop.class, id);
        session.getTransaction().commit();
        return shop;
    }

    @Override
    public void delete(Serializable id) throws SQLException {
        session.getTransaction().begin();
        Shop shop = session.get(Shop.class, id);
        session.delete(shop);
        session.getTransaction().commit();

    }

    @Override
    public List<Shop> readDB() throws SQLException {
        List<Shop> shops = new ArrayList<>();
        session.getTransaction().begin();
        shops = session.createQuery("SELECT s FROM Shop s", Shop.class).list();
        session.getTransaction().commit();
        return shops;
    }

    @Override
    public List<Shop> getShopsWhereLastNames(String jpql, List<String> lastNames) throws SQLException {
        List<Shop> shops = new ArrayList<>();
        session.getTransaction().begin();
        for (String s : lastNames) {
            shops.addAll(session.createQuery("select m.shop FROM Manager m where m.lastName=:lastName ", Shop.class)
                    .setParameter("lastName", s)
                    .list());
        }
        session.getTransaction().commit();
        return shops;
    }

}
