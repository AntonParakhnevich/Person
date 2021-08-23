package com.example.budjet_spring.Services;

/**
 * Created by .
 */
public interface CategoryCostService {
    void addCategoryCost(String nameCategory, Integer amount,Integer binding,Long idMonth);

    void deleteCategoryCost(Long idIncome);
}

