package com.example.budjet_spring.Entity;


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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by .
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "expenses")
public class Expenses implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "expenses",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @Builder.Default
    private Set<CategoryCost> categoryCosts = new HashSet<>();

    @Column
    private int totalExpenses;

    public void addCategory(CategoryCost cost){
        categoryCosts.add(cost);
    }

    public int calculationTotalExpenses() {
        int totalExpenses = 0;
        for (CategoryCost c : categoryCosts) {
            totalExpenses += c.getPrice();
        }
        return totalExpenses;
    }
}
