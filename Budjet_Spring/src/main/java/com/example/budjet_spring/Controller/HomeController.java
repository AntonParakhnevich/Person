package com.example.budjet_spring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

/**
 * Created by .
 */
@Controller
@RequestMapping("/language")
@SessionAttributes("language")
public class HomeController {

    @ModelAttribute("language")
    public String addLanguage() {
        return "";
    }

    @GetMapping()
    public String start(Model model) {
        return "language";
    }

    @PostMapping()
    public ModelAndView choiceLanguage(@RequestParam String language,
                                       @ModelAttribute("language") String lang,
                                       ModelAndView modelAndView,
                                       HttpSession session) {
        lang = language;
        modelAndView.addObject("language", lang);
        modelAndView.setViewName("redirect:/start");
        return modelAndView;
    }
}
