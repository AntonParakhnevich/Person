package IT_ACADEMY;

import lombok.Builder;
import lombok.Data;

/**
 * Created by .
 */
@Data
@Builder
public class People {
    private int id;
    private String name;
    private String surname;
    private int age;
    private Address address;
}
