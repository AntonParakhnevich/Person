package Person;

import java.util.Collection;
import java.util.List;

/**
 * Created by .
 */
public interface WriteReadble {
    void write(Collection<Person> group);
    List<Person> read();
}
