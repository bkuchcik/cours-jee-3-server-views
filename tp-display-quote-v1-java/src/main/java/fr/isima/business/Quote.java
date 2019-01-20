package fr.isima.business;

/**
 * L'objet immuable contenant les citations
 * 
 * @author Benjamin Kuchcik
 * @see Quotes
 */
public class Quote {

    /**
     * Le champ est final, il doit donc être initialisé dans le constructeur.
     * 
     */
    private final String author;

    private final String content;

    private final boolean defaultQuote;

    public Quote(String author, String content) {
        this(author, content, false);
    }

    Quote(String author, String content, boolean defaultQuote) {
        this.author = author;
        this.content = content;
        this.defaultQuote = defaultQuote;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    boolean isDefaultQuote() {
        return defaultQuote;
    }

}
