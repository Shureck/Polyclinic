package com.shureck.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafArrayController {

    @GetMapping("/arrays")
    public String arrayController(Model model) {
        User[] continents = {
                new User("test","Tese"),
                new User("test","Tese"),
                new User("test","Tese")
        };

        model.addAttribute("continents", continents);

        return "MedForm";
    }
}
