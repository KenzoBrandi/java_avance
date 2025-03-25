package cardgame;

/**
 * Classe représentant une carte de base dans un jeu de cartes standard.
 * Implémente l'interface {@link Card} et est comparable à d'autres cartes.
 */
public class BasicCard implements Comparable<Card>, Card {
    /** La couleur (enseigne) de la carte. */
    private Color color;
    
    /** La valeur de la carte. */
    private Value value;

    /**
     * Constructeur de la classe BasicCard.
     * @param color La couleur de la carte (ex: Trèfle, Carreau, Cœur, Pique).
     * @param value La valeur de la carte (ex: 2, 10, Roi, As).
     */
    public BasicCard(Color color, Value value) {
        this.color = color;
        this.value = value;
    }

    /**
     * Retourne la couleur de la carte.
     * @return La couleur sous forme d'un objet {@link Color}.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Retourne la valeur de la carte.
     * @return La valeur sous forme d'un objet {@link Value}.
     */
    public Value getValue() {
        return value;
    }

    /**
     * Compare cette carte à une autre carte.
     *
     * @param card La carte à comparer.
     * @return Un entier négatif si cette carte est plus petite, 
     *         un entier positif si elle est plus grande, 
     *         et 0 si elles sont égales.
     */
    @Override
    public int compareTo(Card card) {
        if (card == null) {
            return 1;
        }
        if ("Joker".equals(card.getClass().getSimpleName())) {
            return -1;
        }
        return getValue().compareTo(card.getValue());
    }

    /**
     * Retourne une représentation textuelle de la carte.
     * @return Une chaîne sous la forme "Valeur-Couleur" (ex: "10-Cœur").
     */
    @Override
    public String toString() {
        return getValue().toString() + "-" + getColor().toString();
    }
}
