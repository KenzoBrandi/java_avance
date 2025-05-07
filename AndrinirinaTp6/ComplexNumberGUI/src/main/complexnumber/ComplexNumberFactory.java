package complexnumber;

/**
 * Interface représentant une fabrique de nombres complexes.
 * Cette interface permet de créer des instances de {@link ComplexNumber}
 * sous différentes formes (par défaut, cartésienne ou polaire).
 */
public interface ComplexNumberFactory {

    /**
     * Crée un nombre complexe par défaut.
     * La forme exacte dépendra de l'implémentation (souvent (0 + 0i)).
     *
     * @return une instance de {@link ComplexNumber}
     */
    ComplexNumber createComplexNumber();

    /**
     * Crée un nombre complexe à partir de coordonnées cartésiennes.
     *
     * @param x la partie réelle
     * @param y la partie imaginaire
     * @return une instance de {@link ComplexNumber} initialisée avec (x, y)
     */
    ComplexNumber createComplexNumberFromCartesian(double x, double y);

    /**
     * Crée un nombre complexe à partir de coordonnées polaires.
     *
     * @param r le module (distance à l'origine)
     * @param theta l'argument (angle en radians)
     * @return une instance de {@link ComplexNumber} initialisée avec (r, θ)
     */
    ComplexNumber createComplexNumberFromPolar(double r, double theta);
}
