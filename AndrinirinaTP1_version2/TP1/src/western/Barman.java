package western;

/**
 * La classe Barman représente un barman dans le contexte du western.
 * Un barman est un humain qui possède un saloon et sert des boissons.
 */
public class Barman extends Human {
    private String barName;

    /**
     * Constructeur qui crée un barman avec un nom spécifique.
     * Le nom du saloon est généré automatiquement en ajoutant "'s saloon" au nom du barman.
     *
     * @param name Nom du barman.
     */
    public Barman(String name) {
        super(name);
        setDrink("gin tonic");
        barName = getName() + "'s saloon";
    }

    /**
     * Constructeur qui crée un barman avec un nom et un nom de saloon personnalisés.
     *
     * @param name    Nom du barman.
     * @param barName Nom du saloon du barman.
     */
    public Barman(String name, String barName) {
        super(name);
        setDrink("gin tonic");
        this.barName = barName;
    }

    /**
     * Affiche la présentation du barman, incluant son rôle et le nom de son saloon.
     */
    public void selfIntroduction() {
        super.selfIntroduction();
        System.out.println("I'm the owner of " + barName);
    }

    /**
     * Retourne le nom du saloon du barman.
     *
     * @return Le nom du saloon.
     */
    public String getBarname() {
        return barName;
    }

    /**
     * Permet au barman de parler en ajoutant "Boss!" à la fin de son message.
     *
     * @param message Le message à afficher.
     */
    public void speak(String message) {
        super.speak(message + ". Boss!");
    }
}
