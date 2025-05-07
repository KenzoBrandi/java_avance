package complexnumber;

/**
 * Implémentation de l'interface {@link ComplexNumberFactory} qui crée
 * des instances de {@link CartesianComplexNumber}.
 */
public class CartesianComplexNumberFactory implements ComplexNumberFactory {

    /**
     * {@inheritDoc}
     *
     * Crée un nombre complexe cartésien avec les valeurs (0, 0).
     */
    @Override
    public ComplexNumber createComplexNumber() {
        return new CartesianComplexNumber(0, 0);
    }

    /**
     * {@inheritDoc}
     *
     * Crée un {@link CartesianComplexNumber} à partir des coordonnées cartésiennes spécifiées.
     */
    @Override
    public ComplexNumber createComplexNumberFromCartesian(double x, double y) {
        return new CartesianComplexNumber(x, y);
    }

    /**
     * {@inheritDoc}
     *
     * Crée un {@link CartesianComplexNumber} à partir des coordonnées polaires spécifiées.
     * Cette méthode convertit les coordonnées polaires en cartésiennes en interne.
     */
    @Override
    public ComplexNumber createComplexNumberFromPolar(double r, double theta) {
        ComplexNumber z = createComplexNumber();
        z.setPolar(r, theta);
        return z;
    }
}
