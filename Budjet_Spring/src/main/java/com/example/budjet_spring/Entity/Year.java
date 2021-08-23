package com.example.budjet_spring.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by .
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "year")
public class Year implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int year;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "budget_id")
    private Budget budget;

    @OneToMany(mappedBy = "year", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @Builder.Default
    private Set<Month> months = new HashSet<>();

    public void addMonth(Month month) {
        months.add(month);
    }

    @Override
    public String toString() {
        return "Year{" +
                "id=" + id +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Year year1 = (Year) o;
        return year == year1.year && Objects.equals(id, year1.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year);
    }
}
