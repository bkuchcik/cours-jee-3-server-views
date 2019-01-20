package fr.isima.cours.jee.controllers

import fr.isima.business.Quote
import fr.isima.business.toIndexedQuotes
import fr.isima.controllers.DisplayQuoteController
import io.kotlintest.matchers.Matcher
import io.kotlintest.matchers.Result
import io.kotlintest.matchers.should
import io.kotlintest.specs.BehaviorSpec

class DisplayQuoteControllerTest : BehaviorSpec({

    given("a valid list of quote") {
        listOf(Quote(author = "Jean", content = "Je suis Jean"),
                Quote(author = "Henri", content = "Je m'appelle Henri"),
                Quote(author = "Lea", content = "Mon nom est Léa, enchanté")).toIndexedQuotes().let { indexedQuotes ->
            val displayQuoteController = DisplayQuoteController(indexedQuotes)
            `when`("first quote is rendered using display quote") {
                displayQuoteController.displayQuote(1).let { htmlString ->
                    then("render contains quote author") {
                        htmlString should contains(indexedQuotes[0].quote.author)
                    }
                    then("render contains quote content") {
                        htmlString should contains(indexedQuotes[0].quote.content)
                    }
                }
            }

        }

    }
})

fun contains(inputString: String) = object : Matcher<String> {
    override fun test(value: String) = Result(value.contains(inputString), "$value should contains $inputString")
}