package western;

import java.util.ArrayList;

/**
 * La classe Ruffian représente un hors-la-loi (un ruffian) dans l'univers du western.
 * Un ruffian a une apparence spécifique, peut kidnapper des dames et a une prime sur sa tête.
 */
public class Ruffian extends Human implements Outlaw {
    private String look;
    private int numberOfKidnappedLadies;
    private ArrayList<Lady> kidnappedLadies;
    private int bounty;
    private boolean jailed;

    /**
     * Constructeur qui initialise un ruffian avec un nom.
     * Par défaut, il boit "Bloody Mary", a une apparence "evil" et une prime de 100 pièces d'or.
     *
     * @param name Le nom du ruffian.
     */
    public Ruffian(String name) {
        super(name);
        setDrink("bloody mary");
        look = "evil";
        numberOfKidnappedLadies = 0;
        kidnappedLadies = new ArrayList<Lady>();
        bounty = 100;
        jailed = false;
    }

    /**
     * Retourne l'apparence du ruffian.
     *
     * @return L'apparence du ruffian sous forme de chaîne de caractères.
     */
    public String getLook() {
        return look;
    }

    /**
     * Retourne le nombre de dames kidnappées par le ruffian.
     *
     * @return Le nombre de dames kidnappées.
     */
    public int getNumberOfKidnappedLadies() {
        return numberOfKidnappedLadies;
    }

    /**
     * Retourne la prime mise sur la tête du ruffian.
     *
     * @return La prime en pièces d'or.
     */
    public int getWantedReward() {
        return bounty;
    }

    /**
     * Retourne un indicateur si le ruffian est en prison.
     *
     * @return true si le ruffian est en prison, false sinon.
     */
    public boolean getJailed() {
        return jailed;
    }

    /**
     * Envoie le ruffian en prison.
     */
    public void sentToJail() {
        jailed = true;
    }

    /**
     * Kidnappe une lady, augmente la prime et le nombre de dames kidnappées.
     *
     * @param lady La lady à kidnapper.
     */
    public void kidnap(Lady lady) {
        speak("Ha ha !" + lady.getName() + ", you are mine now !");
        lady.getKidnapped();
        kidnappedLadies.add(lady);
        numberOfKidnappedLadies++;
        bounty += 50;
    }

    /**
     * Capture le ruffian, libère les dames kidnappées et augmente la notoriété du cowboy.
     *
     * @param cowboy Le cowboy qui capture le ruffian.
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
     * Retourne le nom du ruffian avec son apparence.
     *
     * @return Le nom du ruffian suivi de son apparence ("the evil").
     */
    public String getName() {
        return super.getName() + " the " + look;
    }

    /**
     * Présente le ruffian en mentionnant son apparence, le nombre de dames kidnappées et la prime sur sa tête.
     */
    public void selfIntroduction() {
        super.selfIntroduction();
        speak("I look " + look + " and I kidnapped " + numberOfKidnappedLadies + " ladies!");
        speak("There is a " + bounty + " gold coins bounty on my head, HA HA HA!");
    }
}
