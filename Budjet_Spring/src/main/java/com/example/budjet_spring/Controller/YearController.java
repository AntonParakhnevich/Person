package com.example.budjet_spring.Controller;

import com.example.budjet_spring.Entity.Month;
import com.example.budjet_spring.Services.MonthService;
import com.example.budjet_spring.Services.YearService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.YearMonth;
import java.util.List;

/**
 * Created by .
 */
@Controller
@RequiredArgsConstructor
public class YearController {

    private final YearService yearService;
    private final MonthService monthService;

    @GetMapping("year")
    public ModelAndView getYear(@RequestParam Long year,
                                ModelAndView modelAndView) {
        List<Month> allMonth = yearService.getAllMonth(year);
        modelAndView.addObject("months", allMonth);
        modelAndView.addObject("year", year);
        modelAndView.setViewName("year");
        return modelAndView;
    }

    @PostMapping("year")
    public ModelAndView postYear(@RequestParam Long year,
                                 ModelAndView modelAndView) {
        modelAndView.addObject("year", year);
        modelAndView.setViewName("year");
        return modelAndView;
    }

    @GetMapping("createMonth")
    public ModelAndView addMonth(@RequestParam Long year,
                                 ModelAndView modelAndView) {
        modelAndView.addObject("maxMonth", YearMonth.now());
        modelAndView.addObject("year", year);
        modelAndView.setViewName("createMonth");
        return modelAndView;
    }

    @PostMapping("createMonth")
    public ModelAndView postAddMonth(@RequestParam Long year,
                                     @RequestParam String month,
                                     ModelAndView modelAndView) {
        modelAndView.addObject("year", year);
        if (yearService.existMonth(year, YearMonth.parse(month))) {
            modelAndView.setViewName("createMonth");
        } else {
            yearService.addMonth(YearMonth.parse(month), year);
            modelAndView.setViewName("redirect:/year");
        }
        return modelAndView;
    }

    @PostMapping("backIndex")
    public String backIndex() {
        return "redirect:/index";
    }

    @PostMapping("deleteMonth")
    public ModelAndView deleteMonth(@RequestParam Long idMonth,
                                    @RequestParam Long year,
                                    ModelAndView modelAndView) {
        yearService.deleteMonth(idMonth);
        modelAndView.addObject("year", year);
        modelAndView.setViewName("redirect:/year");
        return modelAndView;
    }

}
