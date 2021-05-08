package IT_ACADEMY;

import java.io.Serializable;
import java.sql.CallableStatement;
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
public class AddressDAO implements DAOAddress {
    private String URL;
    private String USER;
    private String PASSWORD;

    public AddressDAO(String URL, String USER, String PASSWORD) {
        this.URL = URL;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
    }

    @Override
    public Address save(Address address) throws SQLException {
        loadDriver();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
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
            address = Address.builder()
                    .street(resultSet.getString("street"))
                    .house(resultSet.getInt("house"))
                    .build();
        }

        connection.close();
        return address;
    }

    @Override
    public void change(Serializable id, int value) throws SQLException {
        loadDriver();
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        CallableStatement callableStatement = connection.prepareCall("{CALL setHouse(?,?)};");
        callableStatement.setInt(1, (Integer) id);
        callableStatement.setInt(2, value);
        callableStatement.execute();
        connection.close();
    }

    @Override
    public int delete(Serializable id) throws SQLException {
        loadDriver();
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM address WHERE id=?;");
        preparedStatement.setInt(1, (Integer) id);

        preparedStatement.executeUpdate();
        connection.close();
        return 0;
    }

    public Integer count() throws SQLException {
        int count = 0;
        loadDriver();
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT MAx(id) FROM address;");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            count = resultSet.getInt("MAX(id)");
        }
        connection.close();
        return count;
    }

    private void loadDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Address> readDB() throws SQLException {
        ArrayList<Address> addresses = new ArrayList<>();

        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM address;");

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            addresses.add(Address.builder()
                    .id(resultSet.getInt("id"))
                    .street(resultSet.getString("street"))
                    .house(resultSet.getInt("house"))
                    .build());
        }
        connection.close();
        return addresses;
    }
}
