package cardgame;

/**
 * Interface représentant une carte dans un jeu de cartes standard.
 */
public interface Card {

    /**
     * Retourne la couleur (enseigne) de la carte.
     * @return La couleur de la carte sous forme d'un objet {@link Color}.
     */
    Color getColor();

    /**
     * Retourne la valeur de la carte.
     * @return La valeur de la carte sous forme d'un objet {@link Value}.
     */
    Value getValue();

    /**
     * Compare cette carte avec une autre selon un ordre défini.
     * @param card La carte à comparer.
     * @return Un entier
     */
    int compareTo(Card card);

    /**
     * Retourne une représentation String de la carte.
     * @return Une chaîne de caractères représentant la carte.
     */
    String toString();
}
