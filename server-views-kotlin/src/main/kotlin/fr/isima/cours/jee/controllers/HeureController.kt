package fr.isima.cours.jee.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.ofPattern

@Controller
@RequestMapping("/heure")
class HeureController {

    @GetMapping("{version}")
    fun heure(@PathVariable("version") version: String): ModelAndView {
        val currentDateAsString = DateTimeFormatter
                .ofPattern(HH_MM_SS_LE_DD_MM_YYYY)
                .format(LocalDateTime.now())
        return ModelAndView("heureCourante-$version", "currentDateAsString", currentDateAsString)
    }

    @GetMapping
    fun heure(): ModelAndView = heure(version = "v5")

    companion object {
        internal const val HH_MM_SS_LE_DD_MM_YYYY = "HH:mm:ss 'le' dd/MM/yyyy"
    }
}
