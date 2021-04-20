package Person;

import java.util.Collection;
import java.util.List;

/**
 * Created by .
 */
public class Work {
    private WriteReadble readble;


    public Work(WriteReadble readble) {
        this.readble = readble;
    }

    public List<Person> read() {
        return readble.read();
    }

    public void write(Collection<Person> group) {
        readble.write(group);
    }
}
