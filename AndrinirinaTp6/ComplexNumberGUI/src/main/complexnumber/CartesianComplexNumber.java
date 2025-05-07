package complexnumber;

/**
 * Implémentation d'un nombre complexe en coordonnées cartésiennes.
 * Fournit des méthodes pour les opérations classiques sur les nombres complexes.
 */
public class CartesianComplexNumber implements ComplexNumber {

    private double real;
    private double imaginary;

    /**
     * Constructeur de la classe {@code CartesianComplexNumber}.
     *
     * @param x la partie réelle du nombre complexe.
     * @param y la partie imaginaire du nombre complexe.
     */
    public CartesianComplexNumber(double x, double y) {
        real = x;
        imaginary = y;
    }

    // === Accesseurs ===

    /**
     * {@inheritDoc}
     */
    public double getReal() {
        return real;
    }

    /**
     * {@inheritDoc}
     */
    public double getImaginary() {
        return imaginary;
    }

    /**
     * {@inheritDoc}
     */
    public double getModulus() {
        return Math.sqrt(Math.pow(real, 2) + Math.pow(imaginary, 2));
    }

    /**
     * {@inheritDoc}
     */
    public double getArgument() {
        double theta = 0.0;
        if (real >= 0 && getModulus() != 0.0) {
            theta = Math.asin(imaginary / getModulus());
        } else if (real < 0) {
            theta = Math.PI - Math.asin(imaginary / getModulus());
        }
        // Assurer que theta ∈ [0, 2π[
        theta = NormalizeTheta.normalize(theta);
        return theta;
    }

    // === Modificateurs ===

    /**
     * {@inheritDoc}
     */
    public void setCartesian(double x, double y) {
        real = x;
        imaginary = y;
    }

    /**
     * {@inheritDoc}
     */
    public void setPolar(double r, double theta) {
        real = r * Math.cos(theta);
        imaginary = r * Math.sin(theta);
    }

    // === Opérations de calcul ===

    /**
     * {@inheritDoc}
     */
    public ComplexNumber plus(ComplexNumber complex) {
        return new CartesianComplexNumber(
            real + complex.getReal(),
            imaginary + complex.getImaginary()
        );
    }

    /**
     * {@inheritDoc}
     */
    public ComplexNumber minus(ComplexNumber complex) {
        return new CartesianComplexNumber(
            real - complex.getReal(),
            imaginary - complex.getImaginary()
        );
    }

    /**
     * {@inheritDoc}
     */
    public ComplexNumber multiply(ComplexNumber complex) {
        double newReal = (real * complex.getReal()) - (imaginary * complex.getImaginary());
        double newImaginary = (real * complex.getImaginary()) + (imaginary * complex.getReal());
        return new CartesianComplexNumber(newReal, newImaginary);
    }

    /**
     * {@inheritDoc}
     */
    public ComplexNumber conjugate() {
        return new CartesianComplexNumber(real, -imaginary);
    }

    /**
     * Retourne une représentation textuelle du nombre complexe.
     *
     * @return une chaîne de la forme "(a + ib)".
     */
    public String toString() {
        return "(" + real + " + i" + imaginary + ")";
    }
}
