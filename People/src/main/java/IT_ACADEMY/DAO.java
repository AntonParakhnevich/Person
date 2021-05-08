package IT_ACADEMY;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by .
 */
public interface DAO<T> {
    T save(T t) throws SQLException;

    T get(Serializable id) throws SQLException;

    void change(Serializable id,int value) throws SQLException;

    int delete(Serializable id) throws SQLException;
}
