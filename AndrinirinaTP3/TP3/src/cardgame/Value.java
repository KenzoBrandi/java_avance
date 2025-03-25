package cardgame;

/**
 * Énumération représentant les valeurs des cartes dans un jeu de cartes standard.
 */
public enum Value {
    /** Carte 2. */  
    TWO("2"),
    /** Carte 3. */  
    THREE("3"),
    /** Carte 4. */  
    FOUR("4"),
    /** Carte 5. */  
    FIVE("5"),
    /** Carte 6. */  
    SIX("6"),
    /** Carte 7. */  
    SEVEN("7"),
    /** Carte 8. */  
    EIGHT("8"),
    /** Carte 9. */  
    NINE("9"),
    /** Carte 10. */  
    TEN("10"),
    /** Valet (Jack). */  
    JACK("J"),
    /** Dame (Queen). */  
    QUEEN("Q"),
    /** Roi (King). */  
    KING("K"),
    /** As (Ace). */  
    ACE("A");

    /** Symbole associé à la valeur de la carte. */
    private String symbol;

    /**
     * Constructeur privé de l'énumération Value.
     * @param symbol Représentation sous forme de chaîne de caractères de la valeur.
     */
    private Value(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Retourne le symbole associé à la valeur de la carte.
     * @return Le symbole sous forme de chaîne de caractères.
     */
    @Override
    public String toString() {
        return symbol;
    }
}
