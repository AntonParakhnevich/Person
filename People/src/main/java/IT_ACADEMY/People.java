package IT_ACADEMY;

/**
 * Created by .
 */
public class People {
    private int id;
    private String name;
    private String surname;
    private int age;
    private Address address;

    public People(String name, String surname, int age, Address address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public People() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public static PeopleBuilder build() {
        return new PeopleBuilder();
    }

    public static class PeopleBuilder {
        private int id;
        private String name;
        private String surname;
        private int age;
        private Address address;

        public PeopleBuilder id(int id) {
            this.id = id;
            return this;
        }

        public PeopleBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PeopleBuilder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public PeopleBuilder age(int age) {
            this.age = age;
            return this;
        }

        public PeopleBuilder address(Address address) {
            this.address = address;
            return this;
        }

        public People builder() {
            return new People(name, surname, age, address);
        }
    }
}
