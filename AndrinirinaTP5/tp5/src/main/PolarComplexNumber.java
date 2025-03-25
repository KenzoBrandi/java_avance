public class PolarComplexNumber implements ComplexNumber{
    private double modulus;
    private double argument;

    public PolarComplexNumber(double r,double theta){
        modulus = r;
        argument = theta;
    }
    //accesseurs
    public double getReal(){
        return modulus* Math.cos(argument);
    };
    public double getImaginary(){
        return modulus* Math.sin(argument);
    };
    public double getModulus(){
        return modulus;
    };
    public double getArgument(){
        return argument;
    };

    //modificateurs
    public void setCartesian(double x,double y){
        modulus = Math.sqrt(Math.pow(x,2)+Math.pow(y, 2));
        if (x>=0) {
            argument = Math.asin(y / getModulus());
        } else {
            argument = Math.PI - Math.asin(y / getModulus());
        }
    };
    public void setPolar(double r,double theta){
        modulus = r;
        argument = theta;
    };

    //opérations de calcul
    public ComplexNumber plus(ComplexNumber complex){
        PolarComplexNumber newComplex = new PolarComplexNumber(0,0);
        newComplex.setCartesian(getReal()+ complex.getReal(), getImaginary() + complex.getImaginary());
        return newComplex;
    };
    public ComplexNumber minus(ComplexNumber complex){
        PolarComplexNumber newComplex = new PolarComplexNumber(0,0);
        newComplex.setCartesian(getReal()- complex.getReal(), getImaginary() - complex.getImaginary());
        return newComplex;
    };
    public ComplexNumber multiply(ComplexNumber complex){
        PolarComplexNumber newComplex = new PolarComplexNumber(0,0);
        newComplex.setPolar(modulus*complex.getModulus(), argument+ complex.getArgument());;
        return newComplex;
    };
    public ComplexNumber conjugate(){
        PolarComplexNumber newComplex = new PolarComplexNumber(0,0);
        newComplex.setPolar(modulus, -argument);;
        return newComplex;
    };

    public String toString(){
        return "("+modulus+" * e("+argument+"*i))";
    }
}
