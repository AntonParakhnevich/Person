package IT_ACADEMY;


import IT_ACADEMY.Util.HibernateSessionFactoryUtil;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Hello world!
 */
public class App {
    private static final String URL = "jdbc:mysql://localhost:3306/people_home?useUnicode=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static void main(String[] args) throws SQLException {
        List<People> peoples = generatePeople();
        List<Address> addresses = generateAddress();

        PeopleService peopleService = new PeopleService(URL, USER, PASSWORD);
        AddressService addressService = new AddressService(URL, USER, PASSWORD);

        peopleService.saveAll(peoples);
        addressService.saveAll(addresses);

        peopleService.delete(23);
        addressService.delete(45);


        HibernateSessionFactoryUtil.close();
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
