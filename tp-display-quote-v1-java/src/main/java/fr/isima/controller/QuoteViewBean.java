package fr.isima.controller;

import fr.isima.business.Quote;
import fr.isima.business.Quotes;

import static java.util.Objects.requireNonNull;

/**
 * Le choix d'utiliser une classe dite ViewBean permet de faire un code plus
 * leger facilement utilisable dans un EL.
 * <p>
 * <p>
 * L'utilisation d'une classe comme celle-ci à l'avantage de simplifier beaucoup
 * la création de la jsp, puisque nous pouvons
 * </p>
 *
 * @author Benjamin Kuchcik
 */
public class QuoteViewBean {

    /**
     * L'ensemble de citation, permet de situer la quote dans son contexte
     */
    private final Quotes quotes;

    /**
     * La citation courante
     */
    private final Quote quote;

    private QuoteViewBean(Quotes quotes, Quote quote) {
        this.quotes = requireNonNull(quotes, "quotes");
        this.quote = requireNonNull(quote, "quote");
    }

    public Quote getQuote() {
        return quote;
    }

    public boolean isHasNext() {
        return quotes.hasNext(quote);
    }

    public boolean isHasPrevious() {
        return quotes.hasPrevious(quote);
    }


    public boolean isFirst() {
        return quotes.isFirst(quote);
    }

    public boolean isHasNotLastQuote() {
        return quotes.hasNotLast(quote);
    }

    public int getPreviousIndex() {
        return quotes.previousIndex(quote);
    }

    public int getNextIndex() {
        return quotes.nextIndex(quote);
    }

    public int getFirstIndex() {
        return quotes.firstIndex();
    }

    public int getLastIndex() {
        return quotes.lastIndex();
    }

    public String getAuthor() {
        return quote.getAuthor();
    }

    public String getContent() {
        return quote.getContent();
    }

    public static QuoteViewBean withNumero(Quotes quotes, int numero) {
        return new QuoteViewBean(quotes, quotes.get(numero));
    }

    public static QuoteViewBean withExternalQuote(Quote quote) {
        return new QuoteViewBean(Quotes.empty(), quote);
    }

}
