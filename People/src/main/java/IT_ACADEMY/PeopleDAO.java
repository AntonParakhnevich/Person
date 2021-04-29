package IT_ACADEMY;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by .
 */
public class PeopleDAO implements DAO<People> {
    private String URL = "jdbc:mysql://localhost:3306/people_home?useUnicode=true&serverTimezone=UTC";
    private String USER = "root";
    private String PASSWORD = "admin";

    @Override
    public People save(People people) throws SQLException {
        loadDriver();

        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO people (name,surname,age) VALUES (?,?,?);");
        PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT * FROM people WHERE name=? and surname=? and age=? ORDER BY id DESC; ");
        preparedStatement.setString(1, people.getName());
        preparedStatement.setString(2, people.getSurname());
        preparedStatement.setInt(3, people.getAge());
        preparedStatement.executeUpdate();

        preparedStatement1.setString(1, people.getName());
        preparedStatement1.setString(2, people.getSurname());
        preparedStatement1.setInt(3, people.getAge());

        ResultSet resultSet = preparedStatement1.executeQuery();
        while (resultSet.next()) {
            people.setId(resultSet.getInt("id"));
        }

        connection.close();
        preparedStatement.close();
        preparedStatement1.close();
        return people;
    }

    @Override
    public People get(Serializable id) throws SQLException {
        loadDriver();
        People people = null;

        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM people WHERE id=?;");

        preparedStatement.setInt(1, (Integer) id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            people = People.build()
                    .name(resultSet.getString("name"))
                    .surname(resultSet.getString("surname"))
                    .age(resultSet.getInt("age"))
                    .builder();
        }

        connection.close();
        preparedStatement.close();
        return people;
    }

    @Override
    public void change(Serializable id) throws SQLException {
        loadDriver();
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE people SET age=age+? WHERE id=?;");
        preparedStatement.setInt(1, 2);
        preparedStatement.setInt(2, (Integer) id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

    @Override
    public int delete(Serializable id) throws SQLException {
        loadDriver();

        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM people WHERE id=?;");
        preparedStatement.setInt(1, (Integer) id);
        preparedStatement.executeUpdate();

        connection.close();
        preparedStatement.close();
        return 0;
    }

    private void loadDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Integer count() throws SQLException {
        int count = 0;
        loadDriver();
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM people;");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            count++;
        }
        return count;
    }
}
