public interface ComplexNumberFactory {
    ComplexNumber createComplexNumber();
    ComplexNumber createComplexNumberFromCartesian(double x,double y);
    ComplexNumber createComplexNumberFromPolar(double r,double theta);
}
