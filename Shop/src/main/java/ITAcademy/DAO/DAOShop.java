package ITAcademy.DAO;

import ITAcademy.Entity.Shop;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by .
 */
public interface DAOShop extends DAO{
    List<Shop> getShopsWhereLastNames(String jpql,List<String> lastNames) throws SQLException;
}
