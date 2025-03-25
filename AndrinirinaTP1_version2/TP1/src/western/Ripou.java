package western;

import java.util.ArrayList;

/**
 * La classe Ripou représente un shérif corrompu qui agit comme un hors-la-loi.
 * Il peut kidnapper des dames et a une prime sur sa tête.
 */
public class Ripou extends Sheriff implements Outlaw {
    private ArrayList<Lady> kidnappedLadies;
    private int bounty;
    private boolean jailed;

    /**
     * Constructeur qui initialise un shérif corrompu avec un nom.
     * Par défaut, il a une prime initiale de 1000 pièces d'or.
     *
     * @param name Nom du Ripou.
     */
    public Ripou(String name) {
        super(name);
        bounty = 1000;
        kidnappedLadies = new ArrayList<>();
    }

    /**
     * Kidnappe une lady, augmente sa prime et ajoute la lady à la liste des captives.
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
     * Retourne la prime mise sur la tête du Ripou.
     *
     * @return La prime en pièces d'or.
     */
    public int getWantedReward() {
        return bounty;
    }

    /**
     * Capture le Ripou, libère les dames kidnappées et augmente la notoriété du cowboy.
     *
     * @param cowboy Le cowboy qui capture le Ripou.
     */
    public void getCaught(Cowboy cowboy) {
        speak("Argh, I am screwed ! " + cowboy.getName() + ", you got me !.");
        for (Lady lady : kidnappedLadies) {
            cowboy.speak("You are safe now, beautiful " + lady.getName());
            lady.getReleased();
            cowboy.incrementNotoriety();
        }
        kidnappedLadies = new ArrayList<>();
    }

    /**
     * Retourne le nom du Ripou.
     *
     * @return Le nom du Ripou.
     */
    public String getName() {
        return super.getName();
    }

    /**
     * Retourne l'apparence du Ripou.
     *
     * @return L'apparence sous forme de chaîne de caractères ("crooked").
     */
    public String getLook() {
        return "crooked";
    }

    /**
     * Envoie le Ripou en prison.
     */
    public void sentToJail() {
        jailed = true;
    }
}
