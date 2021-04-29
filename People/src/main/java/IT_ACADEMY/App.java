package IT_ACADEMY;


import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        PeopleDAO peopleDAO = new PeopleDAO();
        AddressDAO addressDAO = new AddressDAO();

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


    }

    private static void changeAge(List<People> peoples, PeopleDAO dao) {
        int a = 0;
        try {
            a = dao.count();
            for (int i = a - 1; i <= a; i++) {
                for (People p : peoples) {
                    if (p.getId() == i) {
                        dao.change(i);
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
                        dao.change(i);
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
        List<People> people = Arrays.asList(
                People.build()
                        .name("Anton")
                        .age(22)
                        .surname("Parakhnevich")
                        .builder(),
                People.build()
                        .name("Ivan")
                        .age(25)
                        .surname("Ivanov")
                        .builder(),
                People.build()
                        .name("Petr")
                        .surname("Petrov")
                        .age(30)
                        .builder(),
                People.build()
                        .name("Sergei")
                        .surname("Mashkov")
                        .age(27)
                        .builder(),
                People.build()
                        .name("Kolya")
                        .surname("Igonin")
                        .age(35)
                        .builder());
        return people;
    }

    private static List<Address> generateAddress() {
        List<Address> addresses = Arrays.asList(
                Address.build()
                        .street("Matusevicha")
                        .house(20)
                        .builder(),
                Address.build()
                        .street("Minskaya")
                        .house(10)
                        .builder(),
                Address.build()
                        .street("Pobediteley")
                        .house(105)
                        .builder(),
                Address.build()
                        .street("Nezavisimosti")
                        .house(28)
                        .builder(),
                Address.build()
                        .street("Batova")
                        .house(30)
                        .builder());
        return addresses;
    }
}
