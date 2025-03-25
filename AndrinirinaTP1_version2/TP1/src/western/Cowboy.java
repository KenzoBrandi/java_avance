package western;

import java.util.ArrayList;

/**
 * Un cowboy est un humain reconnu pour son courage et sa capacité à capturer des hors-la-loi.
 */
public class Cowboy extends Human {
    private int notoriety;
    private String quality;
    private ArrayList<Outlaw> captured;

    /**
     * Constructeur qui crée un cowboy avec un nom spécifique.
     * Il boit par défaut du "Manhattan" et possède une qualité de "brave".
     *
     * @param name Nom du cowboy.
     */
    public Cowboy(String name) {
        super(name);
        setDrink("manhattan");
        notoriety = 0;
        quality = "brave";
        captured = new ArrayList<Outlaw>();
    }

    /**
     * Tire sur un hors-la-loi et affiche un message narratif.
     *
     * @param outlaw Le hors-la-loi visé.
     */
    public void shoot(Outlaw outlaw) {
        Story.narrate("The " + quality + " " + getName() + " shoots " + outlaw.getName() + ". PAN !");
        speak("Take this, rascal !");
    }

    /**
     * Retourne la notoriété du cowboy.
     *
     * @return La valeur de notoriété actuelle.
     */
    public int getNotoriety() {
        return notoriety;
    }

    /**
     * Augmente la notoriété du cowboy de 1.
     */
    public void incrementNotoriety() {
        this.notoriety++;
    }

    /**
     * Capture un hors-la-loi, récupère la prime et met à jour la liste des capturés.
     *
     * @param outlaw Le hors-la-loi capturé.
     */
    public void capture(Outlaw outlaw) {
        gain(outlaw.getWantedReward());
        outlaw.getCaught(this);
        captured.add(outlaw);
    }

    /**
     * Remet les hors-la-loi capturés au shérif, reçoit les primes et vide la liste des capturés.
     *
     * @param sheriff Le shérif à qui remettre les hors-la-loi.
     */
    public void handOver(Sheriff sheriff) {
        for (Outlaw outlaw : captured) {
            speak("Here's " + outlaw.getName() + " " + sheriff.getName());
            sheriff.arrest(outlaw);
            gain(outlaw.getWantedReward());
        }
        captured = new ArrayList<Outlaw>();
    }
}
