package com.example.budjet_spring.Services;

import com.example.budjet_spring.Entity.Expenses;
import com.example.budjet_spring.Entity.Income;
import com.example.budjet_spring.Entity.Month;
import com.example.budjet_spring.Entity.Year;
import com.example.budjet_spring.Repositories.MonthRepository;
import com.example.budjet_spring.Repositories.YearRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by .
 */
@Service
@Transactional
@RequiredArgsConstructor
public class YearServiceImpl implements YearService {

    private final YearRepository yearRepository;
    private final MonthRepository monthRepository;

    public List<Year> getAllYear(Long budget) {
        List<Year> years = new ArrayList<>();
        try {
            years = yearRepository.getYearByIdBudget(budget);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return years;
    }

    public List<Month> getAllMonth(Long idYear) {
        List<Month> months = new ArrayList<>();
        try {
            months = yearRepository.getAllMonth(idYear);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return months;
    }

    @Override
    public void addMonth(YearMonth yearMonth, Long idYear) {
        String nameMonth = yearMonth.getMonth().name();
        Year year = yearRepository.getById(idYear);

        Month month = Month.builder().name(nameMonth)
                .year(year)
                .expenses(Expenses.builder().build())
                .income(Income.builder().build())
                .build();
        monthRepository.save(month);
    }

    @Override
    public void deleteMonth(Long idMonth) {
        monthRepository.deleteById(idMonth);
    }

    @Override
    public boolean existMonth(Long idYear, YearMonth yearMonth) {
        return yearRepository.existMonth(idYear, yearMonth.getMonth().name()) > 0;
    }

}
