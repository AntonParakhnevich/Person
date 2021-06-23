package ITAcademy.Service;

import ITAcademy.DAO.DAOShop;
import ITAcademy.DAO.DAOShopImpl;
import ITAcademy.Entity.Manager;
import ITAcademy.Entity.Shop;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by .
 */
public class ServiceShop {
    DAOShopImpl daoShop;

    public ServiceShop(Session session) {
        daoShop=new DAOShopImpl(session);
    }

    public void printAllShops(){
        try {
            List<Shop> shops = daoShop.readDB();
            System.out.println("Shop : ");
            for (Shop s:shops){
                System.out.println(s);
            }
            System.out.println();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void printShopsWhereWorkingManagers(List<String> lastNameManagers){
        try {
            List<Shop> shopsWhereLastNames =
                    daoShop.getShopsWhereLastNames("SELECT s.shop FROM Manager s where s.lastName=:lastName", lastNameManagers);
            for (Shop s:shopsWhereLastNames){
                System.out.println(s);
            }
            System.out.println();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void save(Shop shop){
        try {
            daoShop.save(shop);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
