package ru.gb.spring_Thymeleaf.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;


@org.springframework.stereotype.Controller
public class Controller {

    String fio = "ФИО не получено";

    @RequestMapping("/main")
    public String getMain (){
        return "/main";
    }

    @RequestMapping("/time")
    public String getTime(Model model){
        LocalDateTime time = LocalDateTime.now();
        model.addAttribute("time",time.toLocalTime());
        return "/time";
    }

    @RequestMapping("/getName")
    public String getName(Model model){
        model.addAttribute("fio",fio);
        return "/getName";
    }

    @PostMapping("/getName")
    public String putName (Model model, String firstName, String lastName){
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        fio = firstName +" " + lastName;
        return "/getName";
    }
}
