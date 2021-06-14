package IT_ACADEMY;


import IT_ACADEMY.Entity.Address;
import IT_ACADEMY.Entity.People;
import IT_ACADEMY.Service.AddressService;
import IT_ACADEMY.Service.PeopleService;
import IT_ACADEMY.Util.SessionUtil;

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
        List<People> peoples = generatePeople();
        List<Address> addresses = generateAddress();

        PeopleService peopleService = new PeopleService(URL, USER, PASSWORD);
        AddressService addressService = new AddressService(URL, USER, PASSWORD);

//        addressService.saveAll(addresses);
//        addressService.change(52,5);
//        System.out.println(addressService.readDB());

//        peopleService.saveAll(peoples);
//        peopleService.change(33,2);
//        peopleService.delete(41);
//        peopleService.addAddress(39,52);
//        peopleService.get(24);

        System.out.println(peopleService.readDB());
        SessionUtil.close();
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
