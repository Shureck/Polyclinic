package com.shureck.controllers;

import com.shureck.models.LoginModel;
import com.shureck.models.Project;
import com.shureck.repo.LoginRepos;
import com.shureck.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HtmlController {

    @Autowired
    LoginRepos loginRepos;

    @GetMapping("/create-project")
    public String createProjectForm(Model model) {

        model.addAttribute("project", new Project());
        return "create-project";
    }

    @RequestMapping(value = "/save-project", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody String loginModel(String login, String pass, Boolean vra4) throws Exception {
        LoginModel loginModel = new LoginModel(login, pass, vra4);
        loginRepos.save(new Login(login, pass));
        return loginModel.toString();
    }
}