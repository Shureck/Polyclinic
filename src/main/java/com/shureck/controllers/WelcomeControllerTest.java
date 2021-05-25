package com.shureck.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeControllerTest {

    @RequestMapping("/")
    public String welcome() {
        return "welcome";
    }

}