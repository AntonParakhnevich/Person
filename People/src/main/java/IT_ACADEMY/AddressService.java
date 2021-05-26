package IT_ACADEMY;

import IT_ACADEMY.DAO.AddressDAO;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by .
 */
public class AddressService {
    private String URL;
    private String USER;
    private String PASSWORD;
    private AddressDAO addressDAO = new AddressDAO(URL, USER, PASSWORD);

    public AddressService(String URL, String USER, String PASSWORD) {
        this.URL = URL;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
    }

    public void save(Address address){
        try {
            addressDAO.save(address);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void saveAll(List<Address> addresses){
        for (Address a : addresses) {
            try {
                addressDAO.save(a);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public Address get(Serializable id){
        try {
            return addressDAO.get(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void delete(Serializable id){
        try {
            addressDAO.delete(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void change(Serializable id,int value){
        try {
            addressDAO.change(id,value);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Address> readDB(){
        try {
            return addressDAO.readDB();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
