package complexnumber;

/**
 * Interface représentant un nombre complexe avec des méthodes 
 * d'accès, de modification et d'opérations arithmétiques.
 */
public interface ComplexNumber {

    // === Accesseurs ===

    /**
     * Renvoie la partie réelle du nombre complexe.
     *
     * @return la partie réelle.
     */
    double getReal();

    /**
     * Renvoie la partie imaginaire du nombre complexe.
     *
     * @return la partie imaginaire.
     */
    double getImaginary();

    /**
     * Renvoie le module (ou norme) du nombre complexe.
     * Formellement, sqrt(re² + im²).
     *
     * @return le module du nombre complexe.
     */
    double getModulus();

    /**
     * Renvoie l'argument (ou angle) du nombre complexe en radians.
     * Cet angle est mesuré depuis l'axe des abscisses (x).
     *
     * @return l'argument du nombre complexe en radians.
     */
    double getArgument();


    // === Modificateurs ===

    /**
     * Définit les coordonnées cartésiennes (forme algébrique) du nombre complexe.
     *
     * @param x la nouvelle partie réelle.
     * @param y la nouvelle partie imaginaire.
     */
    void setCartesian(double x, double y);

    /**
     * Définit les coordonnées polaires (module et argument) du nombre complexe.
     *
     * @param r     le module (doit être ≥ 0).
     * @param theta l'argument (en radians).
     */
    void setPolar(double r, double theta);


    // === Opérations de calcul ===

    /**
     * Additionne ce nombre complexe avec un autre.
     *
     * @param complex le nombre complexe à ajouter.
     * @return le résultat de l'addition sous forme d'un nouveau ComplexNumber.
     */
    ComplexNumber plus(ComplexNumber complex);

    /**
     * Soustrait un nombre complexe à ce nombre.
     *
     * @param complex le nombre complexe à soustraire.
     * @return le résultat de la soustraction sous forme d'un nouveau ComplexNumber.
     */
    ComplexNumber minus(ComplexNumber complex);

    /**
     * Multiplie ce nombre complexe avec un autre.
     *
     * @param complex le nombre complexe à multiplier.
     * @return le résultat du produit sous forme d'un nouveau ComplexNumber.
     */
    ComplexNumber multiply(ComplexNumber complex);

    /**
     * Retourne le conjugué de ce nombre complexe.
     * C’est-à-dire, on inverse le signe de la partie imaginaire.
     *
     * @return le conjugué du nombre complexe sous forme d'un nouveau ComplexNumber.
     */
    ComplexNumber conjugate();
}
