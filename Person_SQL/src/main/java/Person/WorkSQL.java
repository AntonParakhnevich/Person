package Person;

import Person.Person;
import Person.WriteReadble;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by .
 */
public class WorkSQL implements WriteReadble {
    private final String URL;
    private final String USER;
    private final String PASSWORD;
    private final String SQL;

    public WorkSQL(String URL, String USER, String PASSWORD, String SQL) {
        this.URL = URL;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
        this.SQL = SQL;
    }


    private void loadDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void write(Collection<Person> group) {
        loadDriver();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            for (Person p : group) {
                PreparedStatement preparedStatement = conn.prepareStatement(SQL);
                preparedStatement.setInt(1, p.getId());
                preparedStatement.setInt(2, p.getName());
                preparedStatement.setInt(3, p.getLastName());
                preparedStatement.setInt(4, p.getAge());
                preparedStatement.setDouble(5, p.getSalary());
                preparedStatement.setString(6, p.getPassport());
                preparedStatement.setString(7, p.getAddress());
                preparedStatement.setDate(8, p.getDateOfBirthday());
                preparedStatement.setTimestamp(9, p.getDateTimeCreate());
                preparedStatement.setTime(10, p.getTimeToLunch());
                preparedStatement.setString(11, p.getLetter());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public List<Person> read() {
        ArrayList<Person> people = new ArrayList<Person>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM person_table");
            while (resultSet.next()) {
                people.add(new Person.PersonBuilder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getInt("name"))
                        .lastName(resultSet.getInt("lastName"))
                        .age(resultSet.getInt("age"))
                        .salary(resultSet.getDouble("salary"))
                        .address(resultSet.getString("address"))
                        .passport(resultSet.getString("passport"))
                        .dateOfBirthday(resultSet.getDate("dateOfBirthday"))
                        .dateTimeCreate(resultSet.getTimestamp("dateTimeCreate"))
                        .timeToLunch(resultSet.getTime("timeToLunch"))
                        .letter(resultSet.getString("letter"))
                        .builder());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return people;
    }
}
