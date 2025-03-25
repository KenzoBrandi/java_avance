package western;

/**
 * La classe Sheriff représente un shérif, un cowboy chargé de maintenir la loi et l'ordre.
 * Un shérif peut rechercher des hors-la-loi, les arrêter et les envoyer en prison.
 */
public class Sheriff extends Cowboy {
    private int ruffiansJailed;

    /**
     * Constructeur qui initialise un shérif avec un nom.
     * Par défaut, il boit un "Moscow Mule" et commence avec un compte de hors-la-loi emprisonnés à zéro.
     *
     * @param name Le nom du shérif.
     */
    public Sheriff(String name) {
        super(name);
        setDrink("moscow mule");
        ruffiansJailed = 0;
    }

    /**
     * Recherche un hors-la-loi et annonce la prime pour celui qui le capture.
     *
     * @param outlaw Le hors-la-loi à rechercher.
     */
    public void searchForRuffian(Outlaw outlaw) {
        speak("OYEZ OYEZ BRAVE PEOPLE !!! " + outlaw.getWantedReward() + " gold coins to the one who will catch "
                + outlaw.getName() + " evil dead or alive !!!");
    }

    /**
     * Arrête un hors-la-loi et l'envoie en prison.
     *
     * @param outlaw Le hors-la-loi à arrêter.
     */
    public void arrest(Outlaw outlaw) {
        speak("In the name of the law, you are under arrest, " + outlaw.getName() + " !");
        outlaw.sentToJail();
        ruffiansJailed++;
    }

    /**
     * Retourne le nom du shérif avec le préfixe "Sheriff".
     *
     * @return Le nom du shérif avec "Sheriff" ajouté au début.
     */
    public String getName() {
        return "Sheriff " + super.getName();
    }
}
