package IT_ACADEMY.Service;

import IT_ACADEMY.DAO.PeopleDAO;
import IT_ACADEMY.Entity.People;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by .
 */
public class PeopleService {
    private String URL;
    private String USER;
    private String PASSWORD;
    private PeopleDAO peopleDAO = new PeopleDAO(URL, USER, PASSWORD);

    public PeopleService(String URL, String USER, String PASSWORD) {
        this.URL = URL;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
    }

    public void save(People people){
        try {
            peopleDAO.save(people);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void saveAll(List<People> peoples){
        for (People p : peoples) {
            try {
                peopleDAO.save(p);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public People get(Serializable id){
        try {
            return peopleDAO.get(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void delete(Serializable id){
        try {
            peopleDAO.delete(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void change(Serializable id, int value){
        try {
            peopleDAO.change(id,value);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addAddress(int people_id,int address_id){
        try {
            peopleDAO.addAddress(people_id,address_id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<People> readDB(){
        try {
            return peopleDAO.readDB();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
