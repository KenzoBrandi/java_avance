public class PolarComplexNumberFactory implements ComplexNumberFactory{
    public ComplexNumber createComplexNumber(){
        return new PolarComplexNumber(0, 0);
    };
    public ComplexNumber createComplexNumberFromCartesian(double x,double y){
        ComplexNumber z = createComplexNumber();
        z.setCartesian(x, y);
        return z;
    };
    public ComplexNumber createComplexNumberFromPolar(double r,double theta){
        return new PolarComplexNumber(r, theta);
    };
}
