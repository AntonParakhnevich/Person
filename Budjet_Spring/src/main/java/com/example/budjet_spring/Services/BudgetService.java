package com.example.budjet_spring.Services;

import javax.servlet.http.HttpSession;

/**
 * Created by .
 */
public interface BudgetService {
    void addYear(Integer year, Long idBudget);

    Integer calculationAccumulationForTheTime(int years, int income, int cost);

    public Integer getTotalAccumulation(Long idBudget);

    public void logout(HttpSession session);
}
