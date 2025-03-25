package western;

/**
 * La classe Story représente des actions de narration dans l'histoire du western.
 * Elle permet de raconter des événements et des scènes comme une poursuite entre un cowboy et un hors-la-loi.
 */
public class Story {

    /**
     * Affiche un texte narratif dans la console.
     *
     * @param text Le texte à narrer.
     */
    public static void narrate(String text) {
        System.out.println(text);
    }

    /**
     * Simule une poursuite entre un cowboy et un hors-la-loi.
     * Le cowboy engage la poursuite, tire sur le hors-la-loi et tente de le capturer.
     *
     * @param cowboy Le cowboy qui poursuit.
     * @param outlaw Le hors-la-loi qui est poursuivi.
     */
    public static void chase(Cowboy cowboy, Outlaw outlaw) {
        cowboy.speak("Here you are " + outlaw.getName() + "\n"
                + "Imma get you now!!"
        );
        cowboy.shoot(outlaw);
        cowboy.capture(outlaw);
    }
}
