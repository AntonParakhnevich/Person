package IT_ACADEMY;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * Created by .
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
@Entity
public class People implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private int age;
    @OneToMany(mappedBy = "people", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;

    public void addAddress(Address address) {
        address.setPeople(this);
        addresses.add(address);
    }

}
