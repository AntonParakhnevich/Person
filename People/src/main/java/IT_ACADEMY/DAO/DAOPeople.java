package IT_ACADEMY.DAO;

import IT_ACADEMY.Entity.People;

import java.sql.SQLException;

/**
 * Created by .
 */
public interface DAOPeople extends DAO<People>{
    void addAddress(int people_id,int address_id) throws SQLException;
}
