package ru.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class OnlineTicketController {

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String startPage(Model model) {
        model.addAttribute("greeting", "123");
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/movie")
    public String moviePage(HttpServletRequest request, HttpServletResponse response, Model model,
                            @RequestParam(value = "name", required = false) String name) throws IOException {
        if (name == null || name.isEmpty()) {
            response.sendError(403, "forbidden");
        } else {
            model.addAttribute("name", name);
        }
        return "movie";
    }

    /* Redirect example
    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public String authorInfo(Model model) {

        // Do somethong here

        return "redirect:/hello";
    }
    */
}
