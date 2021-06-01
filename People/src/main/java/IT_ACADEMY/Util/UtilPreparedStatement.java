package IT_ACADEMY.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * Created by .
 */
public class UtilPreparedStatement {
    private String user;
    private String url;
    private String password;

    public UtilPreparedStatement(String user, String url, String password) {
        this.user = user;
        this.url = url;
        this.password = password;
    }

    public void exeсutePreparedStatement(String sql, Map<Integer, Object> param) {
        loadDriver();
        Set<Integer> keys = param.keySet();

        try (PreparedStatement preparedStatement = ConnectionUtil.getConnection().prepareStatement(sql);) {
//          PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (Integer i : keys) {
                preparedStatement.setObject(i, param.get(i));
            }
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void loadDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
