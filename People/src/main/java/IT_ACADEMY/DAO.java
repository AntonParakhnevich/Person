package IT_ACADEMY;

import java.io.Serializable;
import java.sql.SQLException;

/**
 * Created by .
 */
public interface DAO<T> {
    T save(T t) throws SQLException;

    T get(Serializable id) throws SQLException;

    void change(Serializable id) throws SQLException;

    int delete(Serializable id) throws SQLException;
}
