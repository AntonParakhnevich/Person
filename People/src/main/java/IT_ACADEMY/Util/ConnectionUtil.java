package IT_ACADEMY.Util;

import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by .
 */

public class ConnectionUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/people_home?useUnicode=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";


    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }
}
