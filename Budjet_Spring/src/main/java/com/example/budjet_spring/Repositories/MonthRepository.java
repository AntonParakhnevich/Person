package com.example.budjet_spring.Repositories;

import com.example.budjet_spring.Entity.CategoryCost;
import com.example.budjet_spring.Entity.CategoryIncome;
import com.example.budjet_spring.Entity.Month;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by .
 */
public interface MonthRepository extends JpaRepository<Month, Long> {


    @Query("select ci from CategoryIncome ci where ci.income.id=?1")
    List<CategoryIncome> getAllCategoryIncome(Long idCategoryIncome);

    @Query("select cc from CategoryCost cc where cc.expenses.id=?1")
    List<CategoryCost> getAllCategoryCost(Long idCategoryCost);
}
