package Person;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.Objects;

/**
 * Created by .
 */
public class Person implements Serializable {
    private int id;
    private int age;
    private int name;
    private int lastName;
    private double salary;
    private String passport;
    private String address;
    private Date dateOfBirthday;
    private Timestamp dateTimeCreate;
    private Time timeToLunch;
    private String letter;

    public Person(int id, int age, int name, int lastName, double salary, String passport, String address, Date dateOfBirthday, Timestamp dateTimeCreate, Time timeToLunch, String letter) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
        this.passport = passport;
        this.address = address;
        this.dateOfBirthday = dateOfBirthday;
        this.dateTimeCreate = dateTimeCreate;
        this.timeToLunch = timeToLunch;
        this.letter = letter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                age == person.age &&
                name == person.name &&
                lastName == person.lastName &&
                Double.compare(person.salary, salary) == 0 &&
                Objects.equals(passport, person.passport) &&
                Objects.equals(address, person.address) &&
                Objects.equals(dateOfBirthday, person.dateOfBirthday) &&
                Objects.equals(dateTimeCreate, person.dateTimeCreate) &&
                Objects.equals(timeToLunch, person.timeToLunch) &&
                Objects.equals(letter, person.letter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, name, lastName, salary, passport, address, dateOfBirthday, dateTimeCreate, timeToLunch, letter);
    }

    public int getName() {
        return name;
    }

    public int getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getPassport() {
        return passport;
    }

    public String getAddress() {
        return address;
    }

    public Date getDateOfBirthday() {
        return dateOfBirthday;
    }

    public Timestamp getDateTimeCreate() {
        return dateTimeCreate;
    }

    public Time getTimeToLunch() {
        return timeToLunch;
    }

    public String getLetter() {
        return letter;
    }

    @Override
    public String toString() {
        return " Id :: " + id +
                " , Name :: " + name +
                " , lastName :: " + lastName +
                " , age :: " + age +
                " , salary :: " + salary +
                " , address :: " + address +
                " , date of Birthday :: " + dateOfBirthday + " .\n";
    }

    public static PersonBuilder personBuilder() {
        return new PersonBuilder();
    }

    public static class PersonBuilder {
        private int id;
        private int age;
        private int name;
        private int lastName;
        private double salary;
        private String passport;
        private String address;
        private Date dateOfBirthday;
        private Timestamp dateTimeCreate;
        private Time timeToLunch;
        private String letter;

        public PersonBuilder id(int id) {
            this.id = id;
            return  this;
        }

        public PersonBuilder name(int name) {
            this.name = name;
            return this;
        }

        public PersonBuilder lastName(int lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder age(int age) {
            this.age = age;
            return this;
        }

        public PersonBuilder salary(double salary) {
            this.salary = salary;
            return this;
        }

        public PersonBuilder passport(String passport) {
            this.passport = passport;
            return this;
        }

        public PersonBuilder address(String address) {
            this.address = address;
            return this;
        }

        public PersonBuilder dateOfBirthday(Date dateOfBirthday) {
            this.dateOfBirthday = dateOfBirthday;
            return this;
        }

        public PersonBuilder dateTimeCreate(Timestamp dateTimeCreate) {
            this.dateTimeCreate = dateTimeCreate;
            return this;
        }

        public PersonBuilder timeToLunch(Time timeToLunch) {
            this.timeToLunch = timeToLunch;
            return this;
        }

        public PersonBuilder letter(String letter) {
            this.letter = letter;
            return this;
        }

        public Person builder() {
            return new Person(id, age, name, lastName, salary, passport, address, dateOfBirthday, dateTimeCreate, timeToLunch, letter);
        }

    }
}
