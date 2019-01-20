package fr.isima.controllers

import fr.isima.business.IndexedQuotes
import fr.isima.views.toHtml
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@RequestMapping("/displayQuote")
@Controller
class DisplayQuoteController @Autowired constructor(private val indexedQuotes: IndexedQuotes) {

    @GetMapping("/{quoteNumber}")
    @ResponseBody
    fun displayQuote(@PathVariable("quoteNumber") quoteNumber: Int): String =
        indexedQuotes
            .byNumber(quoteNumber = quoteNumber)
            .toHtml(indexedQuotes)

    @GetMapping
    @ResponseBody
    fun displayQuote() = displayQuote(quoteNumber = 1)
}

