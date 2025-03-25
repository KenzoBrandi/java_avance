public class CartesianComplexNumberFactory implements ComplexNumberFactory{
    public ComplexNumber createComplexNumber(){
        return new CartesianComplexNumber(0, 0);
    };
    public ComplexNumber createComplexNumberFromCartesian(double x,double y){
        return new CartesianComplexNumber(x, y);
    };
    public ComplexNumber createComplexNumberFromPolar(double r,double theta){
        ComplexNumber z = createComplexNumber();
        z.setPolar(r, theta);
        return z;
    };
}
