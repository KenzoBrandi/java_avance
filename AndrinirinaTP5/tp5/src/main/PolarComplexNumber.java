public class PolarComplexNumber implements ComplexNumber{
    private double modulus;
    private double argument;

    public PolarComplexNumber(double r,double theta){
        modulus = r;
        //assurer que theta appartienne à [0;2PI[
        argument = NormalizeTheta.normalize(theta);
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
        argument = 0.0;
        if (x>=0 && modulus !=0) {
            argument = Math.asin(y / modulus);
        } else if(x<0) {
            argument = Math.PI - Math.asin(y / modulus);
        }
        //assurer que l'argument appartienne à [0;2PI[
        argument = NormalizeTheta.normalize(argument);
    };
    public void setPolar(double r,double theta){
        modulus = r;
        //assurer que theta appartienne à [0;2PI[
        argument = NormalizeTheta.normalize(theta);
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
        PolarComplexNumber newComplex = new PolarComplexNumber(modulus, -argument);
        return newComplex;
    };

    public String toString(){
        return "("+modulus+" * e("+argument+"*i))";
    }
}
