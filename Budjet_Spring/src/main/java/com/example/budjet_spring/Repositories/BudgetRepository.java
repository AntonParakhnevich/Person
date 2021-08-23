package com.example.budjet_spring.Repositories;

import com.example.budjet_spring.Entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by .
 */
public interface BudgetRepository extends JpaRepository<Budget,Long> {

}
