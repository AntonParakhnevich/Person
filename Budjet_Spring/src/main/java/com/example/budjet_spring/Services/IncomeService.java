package com.example.budjet_spring.Services;

/**
 * Created by .
 */
public interface IncomeService {
    void addCategoryIncome(String nameCategory, Integer amount,Long idMonth);

    void deleteCategoryIncome(Long idIncome);

}
