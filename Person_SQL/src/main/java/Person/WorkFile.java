package Person;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by .
 */
public class WorkFile implements WriteReadble {
    File file;

    public WorkFile(File file) {
        this.file = file;
    }

    @Override
    public void write(Collection<Person> group) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Person p : group) {
                objectOutputStream.writeObject(p);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> read() {
        return getPeople(file);
    }

    private List<Person> getPeople(File file) {
        ArrayList<Person> people = new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            while (objectInputStream.available() > -1) {
                people.add((Person) objectInputStream.readObject());
            }

        } catch (EOFException ignored) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return people;
    }
}
