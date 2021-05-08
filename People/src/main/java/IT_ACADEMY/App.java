package IT_ACADEMY;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    private static final String URL = "jdbc:mysql://localhost:3306/people_home?useUnicode=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static void main(String[] args) throws SQLException {


        PeopleDAO peopleDAO = new PeopleDAO(URL, USER, PASSWORD);
        AddressDAO addressDAO = new AddressDAO(URL, USER, PASSWORD);

        List<People> peoples = generatePeople();
        List<Address> addresses = generateAddress();

        addPeopleInDB(peoples, peopleDAO);
        changeAge(peoples, peopleDAO);

        try {
            peopleDAO.delete(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        addAddressInDB(addresses, addressDAO);
        changeHouse(addresses, addressDAO);
        try {
            addressDAO.delete(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        peopleDAO.addAddress(15, 3);
    }

    private static void changeAge(List<People> peoples, PeopleDAO dao) {
        try {
            int a = dao.count();
            for (int i = a - 1; i <= a; i++) {
                for (People p : peoples) {
                    if (p.getId() == i) {
                        dao.change(i, 2);
                        p.setAge(dao.get(i).getAge());
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void changeHouse(List<Address> addresses, AddressDAO dao) {
        try {
            int a = dao.count();
            for (int i = a - 1; i <= a; i++) {
                for (Address ad : addresses) {
                    if (ad.getId() == i) {
                        dao.change(i, 10);
                        ad.setHouse(dao.get(i).getHouse());
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addPeopleInDB(List<People> list, PeopleDAO dao) {
        for (People p : list) {
            try {
                dao.save(p);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void addAddressInDB(List<Address> list, AddressDAO dao) {
        for (Address a : list) {
            try {
                dao.save(a);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    private static List<People> generatePeople() {
        return Arrays.asList(

                People.builder()
                        .name("Anton")
                        .age(22)
                        .surname("Parakhnevich")
                        .build(),
                People.builder()
                        .name("Ivan")
                        .age(25)
                        .surname("Ivanov")
                        .build(),
                People.builder()
                        .name("Petr")
                        .surname("Petrov")
                        .age(30)
                        .build(),
                People.builder()
                        .name("Sergei")
                        .surname("Mashkov")
                        .age(27)
                        .build(),
                People.builder()
                        .name("Kolya")
                        .surname("Igonin")
                        .age(35)
                        .build());
    }

    private static List<Address> generateAddress() {
        return Arrays.asList(
                Address.builder()
                        .street("Matusevicha")
                        .house(20)
                        .build(),
                Address.builder()
                        .street("Minskaya")
                        .house(10)
                        .build(),
                Address.builder()
                        .street("Pobediteley")
                        .house(105)
                        .build(),
                Address.builder()
                        .street("Nezavisimosti")
                        .house(28)
                        .build(),
                Address.builder()
                        .street("Batova")
                        .house(30)
                        .build());
    }
}
