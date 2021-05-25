package com.shureck.controllers;

import com.shureck.models.DoctorModel;
import com.shureck.models.LoginModel;
import com.shureck.models.Project;
import com.shureck.repo.LoginRepos;
import com.shureck.repo.SpecRepository;
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
    @Autowired
    SpecRepository specRepository;

    @GetMapping("/create-project")
    public String createProjectForm(Model model) {

        model.addAttribute("project", new Project());
        return "create-project";
    }

    @GetMapping("/form_doctor")
    public String formDoctor(Model model) {
        return "doctorForm";
    }

    @RequestMapping(value = "/add_doctor", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody String doctorModel(String firstName, String lastName, String middleName, String specialtys,
                                           String email, String phoneNumber) throws Exception {
        DoctorModel doctorModel = new DoctorModel(firstName, lastName, middleName, specialtys,
                email, phoneNumber);
        Doctor doctor = new Doctor(firstName, lastName, middleName, email, phoneNumber);
        String[] str = specialtys.split(", ");
        for(int i=0;i<str.length;i++){
            first:
            {
                if (specRepository.findBySpecialtys(str[i]) != null) {
                    Spec spec = specRepository.findBySpecialtys(str[i]);
                    for (int j = 0; j < spec.getDoctors().size(); j++) {
                        if (spec.getDoctors().get(j).getFirstName().equals(doctor.getFirstName())
                                && spec.getDoctors().get(j).getLastName().equals(doctor.getLastName())
                                && spec.getDoctors().get(j).getMiddleName().equals(doctor.getMiddleName())) {
                            break first;
                        }
                    }
                    spec.getDoctors().add(doctor);
                    spec = specRepository.save(spec);
                } else {
                    Spec spec = new Spec(str[i]);
                    spec.getDoctors().add(doctor);
                    spec = specRepository.save(spec);
                }
            }
        }

        return specRepository.findBySpecialtys("Лечу").toString();
    }

    @RequestMapping(value = "/save-project", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody String loginModel(String login, String pass, Boolean vra4) throws Exception {
        return "Test is alright";
    }

}