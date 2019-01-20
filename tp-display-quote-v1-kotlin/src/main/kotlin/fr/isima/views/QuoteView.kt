package fr.isima.views

import fr.isima.business.IndexedQuote
import fr.isima.business.IndexedQuotes
import kotlinx.html.*
import kotlinx.html.stream.createHTML


fun IndexedQuote.toHtml(quotes: IndexedQuotes): String = createHTML().html {
    head {
        script {
            type = "text/javascript"
            src = "/js/jquery-2.2.0.js"
        }
        script {
            type = "text/javascript"
            src = "/js/bootstrap.min.js"
        }
        link {
            rel = "stylesheet"
            type = "text/css"
            href = "/css/bootstrap-theme.min.css"
        }
        link {
            rel = "stylesheet"
            type = "text/css"
            href = "/css/bootstrap.min.css"
        }
    }
    body {
        div {
            classes = setOf("container")
            div {
                classes = setOf("jumbotron")
                h1 {
                    +"Citation "
                    span {
                        id = "number"
                        +"$number"
                    }
                }
                p {
                    classes = setOf("lead")
                    style = "height: 150px"
                    span {
                        +"${quote.content} "
                    }
                    span {
                        style = "font-style: italic;"
                        +quote.author
                    }
                }
                p {
                    div {
                        classes = setOf("btn-group")
                        role = "group"
                        navigationButton {
                            enabled = !isFirst()
                            targetQuoteNumber = quotes.first().number
                            buttonTitle = "Premiere citation"
                        }
                        navigationButton {
                            enabled = hasPrevious()
                            targetQuoteNumber = previous.number
                            buttonTitle = "Citation précédente"
                        }
                        navigationButton {
                            enabled = hasNext()
                            targetQuoteNumber = next.number
                            buttonTitle = "Citation suivante"
                        }
                        navigationButton {
                            enabled = !isLast()
                            targetQuoteNumber = quotes.last().number
                            buttonTitle = "Dernière citation"
                        }
                    }
                }
            }
        }
    }
}

/**
 * An exemple of dsl usage to allow really tasty configuration !
 */
private fun DIV.navigationButton(buttonStateFunction: ButtonState.() -> Unit) {
    ButtonState().apply(buttonStateFunction).apply {
        a {
            role = "button"
            classes = setOf("btn", "btn-lg", "btn-success")
            if (enabled) {
                href = "/displayQuote/$targetQuoteNumber"
            } else {
                classes += "disabled"
            }
            +buttonTitle
        }
    }
}

private data class ButtonState(
        var enabled: Boolean = false,
        var targetQuoteNumber: Int = 1,
        var buttonTitle: String = "undefined"
)
