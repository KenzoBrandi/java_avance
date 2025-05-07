package complexnumber;

/**
 * Représente un nombre complexe en forme polaire.
 */
public class PolarComplexNumber implements ComplexNumber {
    private double modulus;
    private double argument;

    /**
     * Crée un nombre complexe en forme polaire.
     * @param r le module (distance à l'origine)
     * @param theta l'argument (angle en radians)
     */
    public PolarComplexNumber(double r, double theta) {
        modulus = r;
        argument = NormalizeTheta.normalize(theta);
    }

    /** {@inheritDoc} */
    public double getReal() {
        return modulus * Math.cos(argument);
    }

    /** {@inheritDoc} */
    public double getImaginary() {
        return modulus * Math.sin(argument);
    }

    /** {@inheritDoc} */
    public double getModulus() {
        return modulus;
    }

    /** {@inheritDoc} */
    public double getArgument() {
        return argument;
    }

    /** {@inheritDoc} */
    public void setCartesian(double x, double y) {
        modulus = Math.sqrt(x * x + y * y);
        argument = 0.0;
        if (x >= 0 && modulus != 0) {
            argument = Math.asin(y / modulus);
        } else if (x < 0) {
            argument = Math.PI - Math.asin(y / modulus);
        }
        argument = NormalizeTheta.normalize(argument);
    }

    /** {@inheritDoc} */
    public void setPolar(double r, double theta) {
        modulus = r;
        argument = NormalizeTheta.normalize(theta);
    }

    /** {@inheritDoc} */
    public ComplexNumber plus(ComplexNumber complex) {
        PolarComplexNumber newComplex = new PolarComplexNumber(0, 0);
        newComplex.setCartesian(getReal() + complex.getReal(), getImaginary() + complex.getImaginary());
        return newComplex;
    }

    /** {@inheritDoc} */
    public ComplexNumber minus(ComplexNumber complex) {
        PolarComplexNumber newComplex = new PolarComplexNumber(0, 0);
        newComplex.setCartesian(getReal() - complex.getReal(), getImaginary() - complex.getImaginary());
        return newComplex;
    }

    /** {@inheritDoc} */
    public ComplexNumber multiply(ComplexNumber complex) {
        PolarComplexNumber newComplex = new PolarComplexNumber(0, 0);
        newComplex.setPolar(modulus * complex.getModulus(), argument + complex.getArgument());
        return newComplex;
    }

    /** {@inheritDoc} */
    public ComplexNumber conjugate() {
        return new PolarComplexNumber(modulus, -argument);
    }

    /**
     * Retourne une représentation textuelle du nombre complexe en notation exponentielle.
     * @return (r * e(θ * i))
     */
    public String toString() {
        return "(" + modulus + " * e(" + argument + "*i))";
    }
}
