package cardgame;

/**
 * Énumération représentant les couleurs (enseignes) des cartes dans un jeu de cartes standard.
 */
public enum Color {
    /** Trèfle (Club). */
    CLUB("Trèfle"),
    /** Carreau (Diamond). */
    DIAMOND("Carreau"),
    /** Cœur (Heart). */
    HEART("Coeur"),
    /** Pique (Spade). */
    SPADE("Pique");

    /** Symbole associé à la couleur de la carte. */
    private String symbol;

    /**
     * Constructeur privé de l'énumération Color.
     * @param symbol Représentation sous forme de chaîne de caractères de la couleur.
     */
    private Color(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Retourne le symbole associé à la couleur de la carte.
     * @return Le symbole sous forme de chaîne de caractères.
     */
    @Override
    public String toString() {
        return symbol;
    }
}
