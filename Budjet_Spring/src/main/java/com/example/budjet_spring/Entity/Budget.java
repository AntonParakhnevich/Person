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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "budget")
public class Budget implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @JoinTable(name = "budget_year",
//            joinColumns = @JoinColumn(name = "B_ID"),
//            inverseJoinColumns = @JoinColumn(name = "Y_ID"))
//    @Builder.Default
//    private Set<Year> years = new HashSet<>();

    @OneToMany(mappedBy = "budget", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @Builder.Default
    private Set<Year> years = new HashSet<>();

    @OneToOne(cascade = CascadeType.PERSIST)
    private Family family;

    public void addYear(Year year) {
        years.add(year);
    }

    @Column
    public int totalAccumulation;

    public int calculationTotalAccumulation() {
        int total = 0;
        for (Year y : years) {
            Set<Month> months = y.getMonths();
            for (Month m : months) {
                total += m.calculationAccumulationInMonth();
                System.out.println(total);
            }
        }
        return total;
    }

//    public void updateYear(Year year){
//        Iterator<Year> iterator = years.iterator();
//
//        if(iterator.hasNext()){
//            Year next = iterator.next();
//            if(next.getId().equals(year.getId())){
//                years.remove(next);
//                years.add(year);
//            }
//        }
//    }




}
