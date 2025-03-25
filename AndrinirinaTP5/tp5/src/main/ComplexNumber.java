public interface ComplexNumber {
    //accesseurs
    double getReal();
    double getImaginary();
    double getModulus();
    double getArgument();

    //modificateurs
    void setCartesian(double x,double y);
    void setPolar(double r,double theta);

    //opérations de calcul
    ComplexNumber plus(ComplexNumber complex);
    ComplexNumber minus(ComplexNumber complex);
    ComplexNumber multiply(ComplexNumber complex);
    ComplexNumber conjugate();
}