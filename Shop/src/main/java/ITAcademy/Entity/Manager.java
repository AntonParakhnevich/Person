package ITAcademy.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by .
 */

@Getter
@Setter
@Builder
@Entity
@Table(name = "managers")
@NoArgsConstructor
@AllArgsConstructor
public class Manager implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private String surname;

    @Column
    private int salary;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return salary == manager.salary && Objects.equals(id, manager.id) && Objects.equals(firstName, manager.firstName) && Objects.equals(lastName, manager.lastName) && Objects.equals(surname, manager.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, surname, salary);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", shop=" + shop +
                '}';
    }
}
