package complexnumber;

/**
 * Implémentation de l'interface {@link ComplexNumberFactory} qui crée
 * des instances de {@link PolarComplexNumber}.
 */
public class PolarComplexNumberFactory implements ComplexNumberFactory {

    /**
     * {@inheritDoc}
     *
     * Crée un nombre complexe polaire avec un module et un argument initialisés à 0.
     */
    @Override
    public ComplexNumber createComplexNumber() {
        return new PolarComplexNumber(0, 0);
    }

    /**
     * {@inheritDoc}
     *
     * Crée un {@link PolarComplexNumber} à partir de coordonnées cartésiennes.
     * Cette méthode convertit les coordonnées cartésiennes en coordonnées polaires.
     */
    @Override
    public ComplexNumber createComplexNumberFromCartesian(double x, double y) {
        ComplexNumber z = createComplexNumber();
        z.setCartesian(x, y);
        return z;
    }

    /**
     * {@inheritDoc}
     *
     * Crée un {@link PolarComplexNumber} à partir de coordonnées polaires données.
     */
    @Override
    public ComplexNumber createComplexNumberFromPolar(double r, double theta) {
        return new PolarComplexNumber(r, theta);
    }
}
