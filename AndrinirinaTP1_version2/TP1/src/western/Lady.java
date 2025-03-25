package western;

/**
 * La classe Lady représente une dame dans l'univers du western.
 * Une lady a une couleur de robe, peut être kidnappée et libérée.
 */
public class Lady extends Human {
    private String dressColor;
    private boolean captive;

    /**
     * Constructeur qui crée une lady avec un nom et une couleur de robe.
     * Sa boisson favorite est "Pink Lady".
     *
     * @param name  Nom de la lady.
     * @param color Couleur de la robe.
     */
    public Lady(String name, String color) {
        super(name);
        setDrink("pink Lady");
        dressColor = color;
        captive = false;
    }

    /**
     * Permet de capturer la lady, indiquant qu'elle est retenue en otage.
     */
    public void getKidnapped() {
        captive = true;
    }

    /**
     * Libère la lady, indiquant qu'elle n'est plus captive.
     */
    public void getReleased() {
        captive = false;
    }

    /**
     * Change la couleur de la robe de la lady et affiche un message.
     *
     * @param newColor Nouvelle couleur de la robe.
     */
    public void changeDress(String newColor) {
        dressColor = newColor;
        System.out.println("Look at my new " + dressColor + " dress !");
    }

    /**
     * Retourne le nom de la lady avec le préfixe "Lady".
     *
     * @return Le nom de la lady sous la forme "Lady [Nom]".
     */
    public String getName() {
        return "Lady " + super.getName();
    }
}
