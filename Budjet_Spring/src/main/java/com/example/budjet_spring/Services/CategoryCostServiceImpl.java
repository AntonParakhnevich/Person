package com.example.budjet_spring.Services;

import com.example.budjet_spring.Entity.CategoryCost;
import com.example.budjet_spring.Entity.Expenses;
import com.example.budjet_spring.Entity.Month;
import com.example.budjet_spring.Repositories.CategoryCostRepository;
import com.example.budjet_spring.Repositories.MonthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by .
 */
@Service
@RequiredArgsConstructor
public class CategoryCostServiceImpl implements CategoryCostService {

    private final MonthRepository monthRepository;
    private final CategoryCostRepository categoryCostRepository;

    @Override
    public void addCategoryCost(String nameCategory, Integer amount,Integer binding, Long idMonth) {
        Month month = monthRepository.getById(idMonth);
        CategoryCost categoryCost = CategoryCost.builder()
                .name(nameCategory)
                .price(amount)
                .expenses(month.getExpenses())
                .binding(binding)
                .build();
        Expenses expenses = monthRepository.getById(idMonth).getExpenses();
        expenses.addCategory(categoryCost);
        categoryCostRepository.save(categoryCost);
    }

    @Override
    public void deleteCategoryCost(Long idIncome) {
        categoryCostRepository.deleteById(idIncome);
    }
}
