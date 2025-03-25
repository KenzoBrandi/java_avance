package western;

import java.util.ArrayList;

/**
 * La classe RuffianLady représente une lady qui agit comme un hors-la-loi dans l'univers du western.
 * Elle peut kidnapper d'autres dames, et elle a une prime sur sa tête.
 */
public class RuffianLady extends Lady implements Outlaw {
    private ArrayList<Lady> kidnappedLadies;
    private int bounty;
    private boolean jailed;

    /**
     * Constructeur qui initialise une lady hors-la-loi avec un nom et une couleur de robe.
     * Par défaut, elle a une prime de 500 pièces d'or.
     *
     * @param name  Le nom de la lady.
     * @param color La couleur de la robe de la lady.
     */
    public RuffianLady(String name, String color) {
        super(name, color);
        bounty = 500;
        kidnappedLadies = new ArrayList<Lady>();
    }

    /**
     * Kidnappe une lady, ajoute une prime et l'ajoute à la liste des dames kidnappées.
     *
     * @param lady La lady à kidnapper.
     */
    public void kidnap(Lady lady) {
        speak("Ha ha !" + lady.getName() + ", you are mine now !");
        lady.getKidnapped();
        kidnappedLadies.add(lady);
        bounty += 50;
    }

    /**
     * Retourne la prime mise sur la tête de la RuffianLady.
     *
     * @return La prime en pièces d'or.
     */
    public int getWantedReward() {
        return bounty;
    }

    /**
     * Capture la RuffianLady, libère les dames kidnappées et augmente la notoriété du cowboy.
     *
     * @param cowboy Le cowboy qui capture la RuffianLady.
     */
    public void getCaught(Cowboy cowboy) {
        speak("Argh, I am screwed ! " + cowboy.getName() + ", you got me !.");
        for (Lady lady : kidnappedLadies) {
            cowboy.speak("You are safe now, beautiful " + lady.getName());
            lady.getReleased();
            cowboy.incrementNotoriety();
        }
        kidnappedLadies = new ArrayList<Lady>();
    }

    /**
     * Retourne le nom de la RuffianLady.
     *
     * @return Le nom de la lady.
     */
    public String getName() {
        return super.getName();
    }

    /**
     * Retourne l'apparence de la RuffianLady.
     *
     * @return L'apparence de la lady sous forme de chaîne de caractères ("wicked").
     */
    public String getLook() {
        return "wicked";
    }

    /**
     * Envoie la RuffianLady en prison.
     */
    public void sentToJail() {
        jailed = true;
    }
}
