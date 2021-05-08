package IT_ACADEMY;

import lombok.Builder;
import lombok.Data;

/**
 * Created by .
 */

@Data
@Builder
public class Address {
    private int id;
    private String street;
    private int house;
}
