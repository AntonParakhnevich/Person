package com.example.budjet_spring.Controller;

import com.example.budjet_spring.Entity.Family;
import com.example.budjet_spring.Services.FamilyServiceImpl;
import com.example.budjet_spring.Services.YearServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by .
 */

@Controller
@RequiredArgsConstructor
@SessionAttributes("family")
public class StartController {

    private final FamilyServiceImpl familyService;
    private final YearServiceImpl yearService;

    @GetMapping("/start")
    public String start() {
        return "start";
    }

    @ModelAttribute("family")
    public Family addFamily() {
        return new Family();
    }

    @PostMapping("/start")
    public ModelAndView login(@RequestParam String login,
                              @RequestParam String password,
                              @ModelAttribute("family") Family fam,
                              ModelAndView modelAndView) {
        if (familyService.getByLoginAndPassword(login, password) != null) {
            fam = familyService.getByLoginAndPassword(login, password);
            modelAndView.addObject("family", fam);
            modelAndView.addObject("years", yearService.getAllYear(fam.getBudget().getId()));
            modelAndView.setViewName("index");
        } else {
            modelAndView.setViewName("start");
        }
        return modelAndView;
    }

    @GetMapping(value = "/registration")
    public String getRegistration() {
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String postRegistration(@RequestParam(required = false) String login,
                                   @RequestParam(required = false) String password) {
        familyService.registration(login, password);
        return "redirect:/start";
    }
}
