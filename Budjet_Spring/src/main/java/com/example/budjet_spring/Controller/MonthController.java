package com.example.budjet_spring.Controller;

import com.example.budjet_spring.Entity.CategoryCost;
import com.example.budjet_spring.Entity.CategoryIncome;
import com.example.budjet_spring.Services.CategoryCostService;
import com.example.budjet_spring.Services.IncomeService;
import com.example.budjet_spring.Services.MonthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by .
 */
@Controller
@RequiredArgsConstructor
public class MonthController {
    private final MonthService monthService;
    private final IncomeService incomeService;
    private final CategoryCostService costService;

    @GetMapping("month")
    public ModelAndView getMonth(@RequestParam Long idMonth,
                                 @RequestParam Long year,
                                 ModelAndView modelAndView) {
        List<CategoryIncome> allCategoryIncome = monthService.getAllCategoryIncome(idMonth);
        List<CategoryCost> allCategoryCost = monthService.getAllCategoryCost(idMonth);
        modelAndView.addObject("categoriesIncome", allCategoryIncome);
        modelAndView.addObject("categoriesCost", allCategoryCost);
        modelAndView.addObject("year", year);
        modelAndView.addObject("idMonth", idMonth);
        modelAndView.setViewName("month");
        return modelAndView;
    }

    @PostMapping("month")
    public ModelAndView postMonth(@RequestParam Long idMonth,
                                  @RequestParam Long year,
                                  ModelAndView modelAndView) {
        modelAndView.addObject("idMonth", idMonth);
        modelAndView.addObject("year", year);
        modelAndView.setViewName("month");
        return modelAndView;
    }

    @GetMapping("createIncome")
    public ModelAndView createCategoryIncomeGet(@RequestParam Long idMonth,
                                                @RequestParam Long year,
                                                ModelAndView modelAndView) {
        modelAndView.addObject("idMonth", idMonth);
        modelAndView.addObject("year", year);
        modelAndView.setViewName("createCategoryIncome");
        return modelAndView;
    }

    @PostMapping("createIncome")
    public ModelAndView addCategoryIncomePost(@RequestParam String name,
                                              @RequestParam Integer amount,
                                              @RequestParam Long idMonth,
                                              @RequestParam Long year,
                                              ModelAndView modelAndView) {
        incomeService.addCategoryIncome(name, amount, idMonth);
        modelAndView.addObject("idMonth", idMonth);
        modelAndView.addObject("year", year);
        modelAndView.setViewName("redirect:/month");
        return modelAndView;
    }

    @PostMapping("deleteIncome")
    public ModelAndView deleteCategoryIncome(@RequestParam Long idMonth,
                                             @RequestParam Long year,
                                             @RequestParam Long idIncome,
                                             ModelAndView modelAndView) {
        incomeService.deleteCategoryIncome(idIncome);
        modelAndView.addObject("idMonth", idMonth);
        modelAndView.addObject("year", year);
        modelAndView.setViewName("redirect:/month");
        return modelAndView;
    }

    @PostMapping("backYear")
    public ModelAndView backMonth(@RequestParam Long year,
                                  ModelAndView modelAndView) {
        modelAndView.addObject("year", year);
        modelAndView.setViewName("redirect:/year");
        return modelAndView;
    }

    @GetMapping("createCost")
    public ModelAndView createCategoryCostGet(@RequestParam Long idMonth,
                                              @RequestParam Long year,
                                              ModelAndView modelAndView) {
        modelAndView.addObject("idMonth", idMonth);
        modelAndView.addObject("year", year);
        modelAndView.setViewName("createCategoryCost");
        return modelAndView;
    }

    @PostMapping("createCost")
    public ModelAndView addCategoryCostPost(@RequestParam String name,
                                            @RequestParam Integer amount,
                                            @RequestParam Integer binding,
                                            @RequestParam Long idMonth,
                                            @RequestParam Long year,
                                            ModelAndView modelAndView) {
        costService.addCategoryCost(name, amount, binding, idMonth);
        modelAndView.addObject("idMonth", idMonth);
        modelAndView.addObject("year", year);
        modelAndView.setViewName("redirect:/month");
        return modelAndView;
    }

    @PostMapping("deleteCost")
    public ModelAndView deleteCategoryCost(@RequestParam Long idMonth,
                                           @RequestParam Long year,
                                           @RequestParam Long idCost,
                                           ModelAndView modelAndView) {
        costService.deleteCategoryCost(idCost);
        modelAndView.addObject("idMonth", idMonth);
        modelAndView.addObject("year", year);
        modelAndView.setViewName("redirect:/month");
        return modelAndView;
    }


}
