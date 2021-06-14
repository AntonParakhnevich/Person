package ITAcademy.DAO;

import ITAcademy.Entity.Manager;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by .
 */
public interface DAOManager extends DAO<Manager> {
    List<Manager> managers(String jpql) throws SQLException;
    List<Manager> managersCriterionData(String jpql,LocalDateTime localDateTime) throws SQLException;
}
