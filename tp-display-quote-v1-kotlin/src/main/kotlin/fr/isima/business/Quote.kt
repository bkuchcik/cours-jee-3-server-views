package fr.isima.business


val allQuotes = listOf(
        Quote(author = "Georges Clemenceau",
                content = "Un traître est un homme politique qui quitte son parti pour s'inscrire a un autre. Par contre, un converti est un homme politique qui quitte son parti pour s'inscrire au votre."),
        Quote(author = "Tristan Bernard",
                content = "Les hommes sont toujours sincères. Ils changent de sincérité, voilà tout."),
        Quote(author = "Woody Allen",
                content = "La vie est une maladie mortelle sexuellement transmissible."),
        Quote(author = "Woody Allen",
                content = "Dans votre ascension professionnelle, soyez toujours très gentil pour ceux que vous dépassez en montant. Vous les retrouverez au même endroit en redescendant."),
        Quote(author = "Albert Einstein",
                content = "Il y a deux choses d'infini au monde : l'univers et la bétise humaine....mais pour l'univers j'en suis pas très sûr. "),
        Quote(author = "Marcel Proust",
                content = "L'homme n'est pas fait pour travailler et la preuve, c'est que ça le fatigue. "),
        Quote(author = "Oscar Wilde",
                content = "Il n'y a que deux sortes de gens attrayants ; ceux qui savent absolument tout et ceux qui ne savent absolument rien."),
        Quote(author = "François de La Rochefoucauld",
                content = "Comme c'est le caractère des grands esprits de faire entendre en peu de paroles beaucoup de choses, les petits esprits au contraire ont le don de beaucoup parler, et de ne rien dire."))

data class Quote(val author: String, val content: String)

interface IndexedQuote {
    val quote: Quote
    val index: Int
    val number: Int
    val previous: IndexedQuote
    val next: IndexedQuote
    fun isFirst(): Boolean
    fun hasPrevious(): Boolean
    fun hasNext(): Boolean
    fun isLast(): Boolean
    fun isOutOfIndex(): Boolean
}

fun Iterable<Quote>.toIndexedQuotes(): IndexedQuotes = toList().let { quotes ->
    IndexedQuotes(quotes = quotes, indexedQuotes = quotes.map { quote -> IndexedQuoteInBound(quotes = quotes, quote = quote) }.toList())
}

class IndexedQuotes(private val quotes: List<Quote>, private val indexedQuotes: List<IndexedQuote>) : List<IndexedQuote> by indexedQuotes {

    fun byNumber(quoteNumber: Int): IndexedQuote =
            if (quoteNumber < 1 || quoteNumber > size) {
                quotes.outOfBound()
            } else {
                this[quoteNumber - 1]
            }
}

private fun List<Quote>.outOfBound(): IndexedQuote = IndexedQuoteOutOfBound(quotes = this)
private fun List<Quote>.inBound(index: Int): IndexedQuote =
        IndexedQuoteInBound(quotes = this, quote = this[index])

private data class IndexedQuoteInBound(val quotes: List<Quote>, override val quote: Quote) : IndexedQuote {
    override val index: Int get() = quotes.indexOf(quote)
    override val number: Int get() = index + 1
    override val previous: IndexedQuote
        get() = except { isFirst() } navigateTo index - 1
    override val next: IndexedQuote
        get() = except { isLast() } navigateTo index + 1

    private infix fun except(predicate: () -> Boolean) = predicate()
    private infix fun Boolean.navigateTo(dest: Int) = if (this) quotes.outOfBound() else quotes.inBound(dest)

    override fun isFirst() = index == 0
    override fun hasPrevious() = index > 0
    override fun hasNext() = !isLast()
    override fun isLast() = index == quotes.size - 1
    override fun isOutOfIndex() = false
}

private data class IndexedQuoteOutOfBound(private val quotes: List<Quote>) : IndexedQuote {
    override val previous: IndexedQuote get() = this
    override val next: IndexedQuote get() = this
    override val quote =
            Quote(author = "L'auteur de l'application",
                    content = "Vous devez fournir un numero de quote pour que je puisse l'afficher")
    override val index: Int get() = -1
    override val number: Int get() = -1
    override fun isFirst() = false
    override fun hasNext() = false
    override fun isOutOfIndex() = true
    override fun hasPrevious() = false
    override fun isLast() = false
}
