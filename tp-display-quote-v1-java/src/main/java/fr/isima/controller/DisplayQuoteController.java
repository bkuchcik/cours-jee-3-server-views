package fr.isima.controller;

import fr.isima.business.Quote;
import fr.isima.business.Quotes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/displayQuote")
public class DisplayQuoteController {

    // comme specifie dans le sujet, quotes est immuable
    // il peut donc être utilisé comme attribut
    private final Quotes quotes = Quotes.createDefaultQuotes();

    @GetMapping("{quoteNumber}")
    public ModelAndView displayQuote(@PathVariable(value = "quoteNumber") Integer quoteNumber) {
        return new ModelAndView("quote", "quote", createQuoteViewBean(quoteNumber));
    }

    @GetMapping
    public ModelAndView displayQuote() {
        return displayQuote(1);
    }



    private QuoteViewBean createQuoteViewBean(Integer quoteNumber) {
        if (quoteNumber == null) {
            return QuoteViewBean
                    .withExternalQuote(new Quote("L'auteur de l'application", "Vous devez fournir un numero de quote pour que je puisse l'afficher"));
        }
        return QuoteViewBean.withNumero(quotes, quoteNumber);
    }
}
