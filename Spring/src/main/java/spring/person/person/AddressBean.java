package spring.person.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by .
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressBean implements Address {

    private String city;

    private String country;


}
