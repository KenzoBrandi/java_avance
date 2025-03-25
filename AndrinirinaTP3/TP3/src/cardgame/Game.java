package cardgame;

/**
 * Interface représentant un jeu de cartes.
 * Cette interface définit les actions de base d'un jeu, 
 */
public interface Game {

    /**
     * Lance une partie du jeu.
     * Cette méthode exécute les règles du jeu et gère son déroulement.
     */
    void play();

    /**
     * Détermine le gagnant de la partie.
     * 
     * @return La main du joueur gagnant sous forme d'un objet {@link Hand},
     *         ou {@code null} si aucun gagnant n'est déterminé.
     */
    Hand winner();
}
