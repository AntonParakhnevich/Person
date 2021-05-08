package IT_ACADEMY;

import java.sql.SQLException;

/**
 * Created by .
 */
public interface DAOPeople extends DAO<People>{
    void addAddress(int people_id,int address_id) throws SQLException;
}
