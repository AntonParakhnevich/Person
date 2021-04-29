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
public class AddressDAO implements DAO<Address> {
    private String URL = "jdbc:mysql://localhost:3306/people_home?useUnicode=true&serverTimezone=UTC";
    private String USER = "root";
    private String PASSWORD = "admin";

    @Override
    public Address save(Address address) throws SQLException {
        loadDriver();
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO address(street,house) VALUES (?,?);");
        PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT * FROM address WHERE street=? and house=? ORDER BY id DESC ;");

        preparedStatement.setString(1, address.getStreet());
        preparedStatement.setInt(2, address.getHouse());
        preparedStatement.executeUpdate();

        preparedStatement1.setString(1, address.getStreet());
        preparedStatement1.setInt(2, address.getHouse());

        ResultSet resultSet = preparedStatement1.executeQuery();
        while (resultSet.next()) {
            address.setId(resultSet.getInt("id"));
        }

        connection.close();
        preparedStatement.close();
        preparedStatement1.close();

        return address;
    }

    @Override
    public Address get(Serializable id) throws SQLException {
        loadDriver();
        Address address = null;
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM address WHERE id=?;");
        preparedStatement.setInt(1, (Integer) id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            address = Address.build()
                    .street(resultSet.getString("street"))
                    .house(resultSet.getInt("house"))
                    .builder();
        }

        connection.close();
        preparedStatement.close();
        return address;
    }

    @Override
    public void change(Serializable id) throws SQLException {

        loadDriver();
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE address SET house=house+? WHERE id=?;");
        preparedStatement.setInt(1, 2);
        preparedStatement.setInt(2, (Integer) id);
        preparedStatement.executeUpdate();

        connection.close();
        preparedStatement.close();

    }

    @Override
    public int delete(Serializable id) throws SQLException {
        loadDriver();
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM address WHERE id=?;");
        preparedStatement.setInt(1, (Integer) id);

        preparedStatement.executeUpdate();
        connection.close();
        preparedStatement.close();
        return 0;
    }

    public Integer count() throws SQLException{
        int count=0;
        loadDriver();
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM address;");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            count++;
        }
        return count;
    }

    private void loadDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
