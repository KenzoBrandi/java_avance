package western;

/**
 * L'interface Outlaw représente un hors-la-loi dans l'univers du western.
 * Un hors-la-loi peut kidnapper des dames, être capturé par un cowboy et avoir une prime sur sa tête.
 */
public interface Outlaw {

    /**
     * Permet au hors-la-loi d'enlever une lady.
     *
     * @param lady La lady à kidnapper.
     */
    public void kidnap(Lady lady);

    /**
     * Retourne la prime mise sur la tête du hors-la-loi.
     *
     * @return La récompense en pièces d'or.
     */
    public int getWantedReward();

    /**
     * Indique que le hors-la-loi a été capturé par un cowboy.
     *
     * @param cowboy Le cowboy qui capture le hors-la-loi.
     */
    public void getCaught(Cowboy cowboy);

    /**
     * Retourne le nom du hors-la-loi.
     *
     * @return Le nom du hors-la-loi.
     */
    public String getName();

    /**
     * Retourne l'apparence ou le style du hors-la-loi.
     *
     * @return L'apparence du hors-la-loi sous forme de chaîne de caractères.
     */
    public String getLook();

    /**
     * Indique que le hors-la-loi est envoyé en prison.
     */
    public void sentToJail();
}
