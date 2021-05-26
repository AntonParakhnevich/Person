package ITAcademy.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by .
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address implements Serializable {

    private String street;

    private String city;

}
