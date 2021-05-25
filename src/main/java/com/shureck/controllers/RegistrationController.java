package com.shureck.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private SecureUserService secureUserService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new SecureUser());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody String loginModel(String username, String password, String passwordConfirm) throws Exception {

        SecureUser userForm = new SecureUser(username, password, passwordConfirm);

        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())){
            return "registration";
        }
        if (!secureUserService.saveUser(userForm)){
            return "registration";
        }

        return "redirect:/";
    }
}
