package com.example.budjet_spring.Services;

import com.example.budjet_spring.Entity.CategoryCost;
import com.example.budjet_spring.Entity.CategoryIncome;
import com.example.budjet_spring.Entity.Month;
import com.example.budjet_spring.Repositories.MonthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by .
 */
@Service
@RequiredArgsConstructor
public class MonthServiceImpl implements MonthService {
    private final MonthRepository monthRepository;

    @Override
    public List<CategoryIncome> getAllCategoryIncome(Long idMonth) {
        Month month = monthRepository.getById(idMonth);
        return monthRepository.getAllCategoryIncome(month.getIncome().getId());
    }

    @Override
    public List<CategoryCost> getAllCategoryCost(Long idMonth) {
        Month month = monthRepository.getById(idMonth);
        return monthRepository.getAllCategoryCost(month.getIncome().getId());
    }

}
