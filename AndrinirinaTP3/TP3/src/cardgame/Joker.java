package cardgame;

/**
 * Classe représentant un Joker dans un jeu de cartes.
 * Un Joker est une carte spéciale qui n'a ni couleur ni valeur.
 */
public class Joker implements Card {

    /**
     * Retourne la couleur du Joker.
     * Comme un Joker n'a pas de couleur, cette méthode retourne {@code null}.
     *
     * @return Toujours {@code null}.
     */
    @Override
    public Color getColor() {
        return null;
    }

    /**
     * Retourne la valeur du Joker.
     * Comme un Joker n'a pas de valeur spécifique, cette méthode retourne {@code null}.
     *
     * @return Toujours {@code null}.
     */
    @Override
    public Value getValue() {
        return null;
    }

    /**
     * Compare le Joker avec une autre carte.
     *
     * @param card La carte à comparer.
     * @return 1 si l'autre carte est basique, 0 s'il c'est un autre Joker.
     */
    @Override
    public int compareTo(Card card) {
        if (card == null) {
            return 1;
        }
        if ("Joker".equals(card.getClass().getSimpleName())) {
            return 0;
        }
        return 1;
    }

    /**
     * Retourne une représentation String du Joker.
     *
     * @return La chaîne de caractères "Joker".
     */
    @Override
    public String toString() {
        return "Joker";
    }
}
