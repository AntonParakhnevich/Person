package com.example.budjet_spring.Services;

import com.example.budjet_spring.Entity.CategoryIncome;
import com.example.budjet_spring.Entity.Income;
import com.example.budjet_spring.Entity.Month;
import com.example.budjet_spring.Repositories.CategoryIncomeRepository;
import com.example.budjet_spring.Repositories.MonthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by .
 */
@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {

    private final MonthRepository monthRepository;
    private final CategoryIncomeRepository categoryIncomeRepository;

    @Override
    public void addCategoryIncome(String nameCategory, Integer amount, Long idMonth) {
        Month month = monthRepository.getById(idMonth);
        CategoryIncome categoryIncome = CategoryIncome.builder()
                .name(nameCategory)
                .value(amount)
                .income(month.getIncome())
                .build();
        Income income = monthRepository.getById(idMonth).getIncome();
        income.addCategory(categoryIncome);
        categoryIncomeRepository.save(categoryIncome);
    }

    @Override
    public void deleteCategoryIncome(Long idIncome) {
        categoryIncomeRepository.deleteById(idIncome);
    }


}
