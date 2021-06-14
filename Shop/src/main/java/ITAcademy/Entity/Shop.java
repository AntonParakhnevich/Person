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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by .
 */

@Getter
@Setter
@Builder
@Entity
@Table(name = "shops")
@NoArgsConstructor
@AllArgsConstructor
public class Shop implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int proceeds;

    @Column
    private LocalDateTime date;

    @Column
    private String name;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "shop")
    private Address address;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
    @Builder.Default
    private Set<Manager> managers = new HashSet<>();

    public void addManager(Manager manager) {
        managers.add(manager);
    }


    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", proceeds=" + proceeds +
                ", date=" + date +
                ", name='" + name + '\'' +
                '}';
    }
}
