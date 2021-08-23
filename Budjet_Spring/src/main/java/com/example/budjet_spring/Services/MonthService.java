package com.example.budjet_spring.Services;

import com.example.budjet_spring.Entity.CategoryCost;
import com.example.budjet_spring.Entity.CategoryIncome;

import java.util.List;

/**
 * Created by .
 */
public interface MonthService {
    List<CategoryIncome> getAllCategoryIncome(Long idMonth);

    List<CategoryCost> getAllCategoryCost(Long idMonth);
}
