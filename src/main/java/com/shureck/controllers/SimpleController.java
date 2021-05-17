package com.shureck.controllers;

import com.shureck.models.Group;
import com.shureck.models.Student;
import com.shureck.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
class SimpleController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/addUsr")
    @ResponseBody
    public String addUsr(@RequestParam(required = false) int id) {
        userRepository.save(new User("Alex", "Lev"));
        return "Смэртъ";
    }

    @GetMapping("/findUsr")
    @ResponseBody
    public String findUsr(@RequestParam(required = false) String str) {
        User user = userRepository.findUserByLastName(str);
        return user.getFirstName();
    }

    Group group = new Group("ИКБО-13-19");

    @GetMapping("/getAll")
    public @ResponseBody String getAll() {
        return group.toString();
    }

    @GetMapping("/del")
    @ResponseBody
    public String del(@RequestParam int id) {
        String s = group.getStudentsGroup().get(id).toString();
        group.getStudentsGroup().remove(id);
        return s+" удалён";
    }

    @PostMapping("/addStudent")
    @ResponseBody
    public String addStudent(@RequestBody Student student) {
        group.addStudent(student);
        return String.valueOf(student);
    }

    @PostMapping("/postbody")
    public String postBody(@RequestBody String fullName) {
        return "Hello " + fullName;
    }


}
