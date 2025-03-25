package western;

/**
 * La classe abstraite Human représente un être humain dans l'univers du western.
 * Un humain possède un nom, une boisson favorite et un portefeuille avec de l'argent.
 */
public abstract class Human {
    private String name;
    private String drink;
    protected int wallet;

    /**
     * Constructeur qui initialise un humain avec un nom.
     * Par défaut, il boit de l'eau et possède 1 pièce d'or.
     *
     * @param nom Le nom de l'humain.
     */
    public Human(String nom) {
        name = nom;
        drink = "water";
        wallet = 1;
    }

    /**
     * Permet à l'humain de parler en affichant un message.
     *
     * @param message Le message à afficher.
     */
    public void speak(String message) {
        System.out.println("(" + name + ")- " + message);
    }

    /**
     * Présente l'humain en mentionnant son nom et sa boisson favorite.
     */
    public void selfIntroduction() {
        speak("Hi ! I am " + getName() + ", and I drink " + drink);
    }

    /**
     * Permet à l'humain de boire une boisson au saloon, s'il a assez d'argent.
     * Il paye le barman pour la boisson.
     *
     * @param barman Le barman chez qui l'humain boit.
     */
    public void drink(Barman barman) {
        if (wallet > 0) {
            speak("Ah ! A good glass of " + drink + " ! GLOUPS !");
            barman.gain(1);
        } else {
            speak("I wish I had one gold coin for a drink! Pfff!");
        }
    }

    /**
     * Retourne le nom de l'humain.
     *
     * @return Le nom de l'humain.
     */
    public String getName() {
        return name;
    }

    /**
     * Retourne la boisson préférée de l'humain.
     *
     * @return La boisson préférée.
     */
    public String getDrink() {
        return drink;
    }

    /**
     * Modifie la boisson préférée de l'humain.
     *
     * @param newDrink La nouvelle boisson préférée.
     */
    public void setDrink(String newDrink) {
        drink = newDrink;
    }

    /**
     * Permet à l'humain de dépenser de l'argent de son portefeuille.
     * Si l'humain n'a pas assez d'argent, un message est affiché.
     *
     * @param money Montant à dépenser.
     */
    public void spend(int money) {
        if (wallet >= money) {
            wallet -= money;
        } else {
            speak("I only have " + wallet + " gold coins on me!");
        }
    }

    /**
     * Permet à l'humain de gagner de l'argent.
     *
     * @param money Montant à ajouter au portefeuille.
     */
    public void gain(int money) {
        wallet += money;
    }
}
