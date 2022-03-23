package ru.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OnlineTicketController {
    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String startPage(Model model) {
        model.addAttribute("greeting", "123");
        return "index";
    }
}
