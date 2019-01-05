package fr.isima.cours.jee.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/heure")
public class HeureController {

    static final String HH_MM_SS_LE_DD_MM_YYYY = "HH:mm:ss 'le' dd/MM/yyyy";

    @GetMapping("{version}")
    public ModelAndView heure(@PathVariable("version") String version) {
        final DateTimeFormatter formatteur = DateTimeFormatter.ofPattern(HH_MM_SS_LE_DD_MM_YYYY);
        final String currentDateAsString = formatteur.format(LocalDateTime.now());
        return new ModelAndView("heureCourante-" + version, "currentDateAsString", currentDateAsString);
    }

    @GetMapping
    public ModelAndView heure() {
        return heure("v5");
    }
}
