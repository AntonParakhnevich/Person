package Person;

import java.io.File;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {
    private static Random random = new Random();
    private static final String URL = "jdbc:mysql://localhost:3306/person?useUnicode=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";
    private static final String SQL =
            "INSERT person_table(id,name,lastName,age,salary,passport,address,dateOfBirthday,dateTimeCreate,timeToLunch,letter) VALUES (?,?,?,?,?,?,?,?,?,?,?);";


    public static void main(String[] args) {
        File file = new File("group.txt");
        File file1 = new File("group.txt");
        File file2 = new File("group.txt");

        Work workSQL = new Work(new WorkSQL(URL, USER, PASSWORD, SQL));
        Work workFile = new Work(new WorkFile(file));

        List<Person> group = generateGroup();

        deleteAge21(group);

        Set<Person> sortedGroup = deleteDoublePerson(group);

        workSQL.write(sortedGroup);

        System.out.println(sortedGroup);
        System.out.println(workSQL.read());

        workFile.write(sortedGroup);
        System.out.println(workFile.read());


    }

    private static Set<Person> deleteDoublePerson(List<Person> group) {
        return group.stream()
                .sorted(Comparator.comparing(Person::getLastName).thenComparing(Person::getName))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private static List<String> readNameAndSurname(Collection<Person> group) {
        ArrayList<String> groupNameAndLastName = new ArrayList<>();
        for (Person p : group) {
            groupNameAndLastName.add(p.getName() + " " + p.getLastName());
        }
        return groupNameAndLastName;
    }

    public static List<Person> generateGroup() {
        ArrayList<Person> people = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            people.add(Person.personBuilder()
                    .id(i)
                    .name(random.nextInt(10))
                    .lastName(random.nextInt(20))
                    .age(random.nextInt(15) + 15)
                    .salary(random.nextInt(500) + 100)
                    .address("Minsk")
                    .timeToLunch(new Time(random.nextInt()))
                    .dateTimeCreate(new Timestamp(System.currentTimeMillis()))
                    .dateOfBirthday(new Date(System.currentTimeMillis()-random.nextInt(1000000000)))
                    .builder());
        }
        return people;
    }

    public static Collection<Person> deleteAge21(Collection<Person> group) {
        group.removeIf(p -> p.getAge() > 21);
        return group;
    }
}

