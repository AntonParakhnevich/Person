package ITAcademy.DAO;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by .
 */
public interface DAO<T> {
    void save(T t) throws SQLException;

    T get(Serializable id) throws SQLException;

    void delete(Serializable id) throws SQLException;

    List<T> readDB() throws SQLException;
}
