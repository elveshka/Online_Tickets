package ru.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OnlineTicketController {
    @RequestMapping("/")
    public String startPage(Model model) {
        model.addAttribute("greeting", "This is start page");
        return "index";
    }
}
