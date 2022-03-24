package ru.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class OnlineTicketController {

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String startPage() {
        return "redirect:/top_movies";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/top_movies")
    public String topMoviesPage(Model model) {
        model.addAttribute("firstRate", "1");
        model.addAttribute("secondRate", "2");
        model.addAttribute("thirdRate", "3");
        //todo insert actual rated movies from DB
        return "top_movies";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/movie/search")
    public String moviePage(HttpServletResponse response, Model model,
                            @RequestParam(value = "name", required = false) String name) throws IOException {
        if (name == null || name.isEmpty()) {
            response.sendError(403, "forbidden");
        } else {
            model.addAttribute("name", name);
            model.addAttribute("director", "director");
            model.addAttribute("year", "year");
            model.addAttribute("rate", "rate");
        }
        //todo insert actual movie data from DB
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
