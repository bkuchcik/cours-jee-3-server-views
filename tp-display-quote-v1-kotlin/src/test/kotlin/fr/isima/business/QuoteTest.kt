package fr.isima.business

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec

class QuoteTest : BehaviorSpec({

    given("the quotes in a list") {
        val quotes = (1..3)
                .map { Quote(author = "author$it", content = "content$it") }
                .toIndexedQuotes()

        `when`("I get the first quote") {
            quotes[0].let { firstQuote ->
                then("first should be true") {
                    firstQuote.isFirst() shouldBe true
                }
                then("index should be 0") {
                    firstQuote.index shouldBe 0
                }
                then("number should be 1") {
                    firstQuote.number shouldBe 1
                }
                then("hasPrevious should be false") {
                    firstQuote.hasPrevious() shouldBe false
                }
                then("hasNext should be true") {
                    firstQuote.hasNext() shouldBe true
                }
                then("previous should be out of index") {
                    firstQuote.previous.isOutOfIndex() shouldBe true
                }

            }
        }
        `when`("I get the second quote") {
            quotes[1].let { quote ->
                then("first should be false") {
                    quote.isFirst() shouldBe false
                }
                then("first should be false") {
                    quote.index shouldBe 1
                }
                then("second should have previous") {
                    quote.hasPrevious() shouldBe true
                }
                then("is last should be false") {
                    quote.isLast() shouldBe false
                }
                then("previous quote should be first") {
                    quote.previous shouldBe quotes[0]
                }
                then("previous quote should be first") {
                    quote.next shouldBe quotes[2]
                }
            }
        }
        `when`("I get the last quote") {
            quotes[2].let { lastQuote ->
                then("first should be false") {
                    lastQuote.isFirst() shouldBe false
                }
                then("has next should be false") {
                    lastQuote.hasNext() shouldBe false
                }
                then("isLast should be true") {
                    lastQuote.isLast() shouldBe true
                }
                then("next should be out of bound") {
                    lastQuote.next.isOutOfIndex() shouldBe true
                }
            }
        }
        `when`("I get the first quote by number") {
            quotes.byNumber(1).let {
                then("quote should be first") {
                    it.isFirst() shouldBe true
                }
            }
            quotes.byNumber(4).let {
                then("quote should be out of index") {
                    it.isOutOfIndex() shouldBe true
                }
                then("is fisrt should be false") {
                    it.isFirst() shouldBe false
                }
                then("has next should be false") {
                    it.hasNext() shouldBe false
                }
                then("has next should be false") {
                    it.hasPrevious() shouldBe false
                }
                then("is last should be false") {
                    it.isLast() shouldBe false
                }
                then("quote.author should be `L'auteur de l'application`") {
                    it.quote.author shouldBe "L'auteur de l'application"
                }
                then("index should be -1"){
                    it.index shouldBe -1
                }
                then("number should be -1") {
                    it.number shouldBe -1
                }
                then("it should equals previous") {
                    it shouldBe it.previous
                }
                then("it should equals next") {
                    it shouldBe it.next
                }
            }
        }
    }

    given("a single quote set") {
        listOf(Quote(author = "author", content = "content")).apply {
            `when`("we createIndexed quotes") {
                toIndexedQuotes().let { quotes ->
                    quotes.first().let { singleQuote ->
                        then("has next should be false") {
                            singleQuote.hasNext() shouldBe false
                        }
                        then("has previous should be false"){
                            singleQuote.hasPrevious() shouldBe false
                        }
                    }
                }
            }
        }
    }
})
