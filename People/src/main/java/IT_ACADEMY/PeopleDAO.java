package IT_ACADEMY;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by .
 */
public class PeopleDAO implements DAOPeople {
    private String URL;
    private String USER;
    private String PASSWORD;

    public PeopleDAO(String URL, String USER, String PASSWORD) {
        this.URL = URL;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
    }

    @Override
    public People save(People people) throws SQLException {
        loadDriver();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
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
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            if (connection != null) {
                connection.rollback();
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
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
            people = People.builder()
                    .name(resultSet.getString("name"))
                    .surname(resultSet.getString("surname"))
                    .age(resultSet.getInt("age"))
                    .build();
        }

        connection.close();
        return people;
    }

    @Override
    public void change(Serializable id, int value) throws SQLException {
        loadDriver();
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE people SET age=age+? WHERE id=?;");
        preparedStatement.setInt(1, value);
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
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT MAX(id) FROM people;");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            count = resultSet.getInt("MAX(id)");
        }
        connection.close();
        return count;
    }

    @Override
    public void addAddress(int people_id, int address_id) throws SQLException {
        loadDriver();
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE people SET address_id=? WHERE id=?;");
        preparedStatement.setInt(1, address_id);
        preparedStatement.setInt(2, people_id);
        preparedStatement.executeUpdate();
        connection.close();
    }

    public List<People> readDB() throws SQLException {
        ArrayList<People> peoples = new ArrayList<>();

        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM people;");
        PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT * FROM address WHERE id=?;");


        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Address address = null;
            preparedStatement1.setInt(1, resultSet.getInt("address_id"));
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            while (resultSet1.next()) {
                address = Address.builder()
                        .id(resultSet1.getInt("id"))
                        .street(resultSet1.getString("street"))
                        .house(resultSet1.getInt("house"))
                        .build();
            }
            peoples.add(People.builder()
                    .id(resultSet.getInt("id"))
                    .name(resultSet.getString("name"))
                    .surname(resultSet.getString("surname"))
                    .age(resultSet.getInt("age"))
                    .address(address)
                    .build());
        }
        connection.close();
        return peoples;
    }
}
