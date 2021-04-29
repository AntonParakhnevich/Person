package IT_ACADEMY;

/**
 * Created by .
 */
public class Address {
    private int id;
    private String street;
    private int house;

    public Address(int id, String street, int house) {
        this.id = id;
        this.street = street;
        this.house = house;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public int getHouse() {
        return house;
    }

    public static AddressBuilder build() {
        return new AddressBuilder();
    }

    public static class AddressBuilder {
        private int id;
        private String street;
        private int house;

        public AddressBuilder id(int id) {
            this.id = id;
            return this;
        }

        public AddressBuilder street(String street) {
            this.street = street;
            return this;
        }

        public AddressBuilder house(int house) {
            this.house = house;
            return this;
        }

        public Address builder() {
            return new Address(id, street, house);
        }
    }
}
