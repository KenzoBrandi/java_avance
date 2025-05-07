public class CartesianComplexNumber implements ComplexNumber{
    private double real;
    private double imaginary;
    public CartesianComplexNumber(double x,double y){
        real = x;
        imaginary = y;
    }
    
    //accesseurs
    public double getReal(){
        return real;
    };
    public double getImaginary(){
        return imaginary;
    };
    public double getModulus(){
        return Math.sqrt(Math.pow(real,2)+Math.pow(imaginary, 2));
    };
    public double getArgument(){
        double theta = 0.0;
        if (real>=0 && getModulus() != 0.0 ) {
            theta = Math.asin(imaginary / getModulus());
        } else if (real < 0) {
            theta = Math.PI - Math.asin(imaginary / getModulus());
        }
        //assurer que theta appartienne à [0;2PI[
        theta = NormalizeTheta.normalize(theta);
        return theta;
    };

    //modificateurs
    public void setCartesian(double x,double y){
        real = x;
        imaginary = y;
    };
    public void setPolar(double r,double theta){
        real = r * Math.cos(theta);
        imaginary = r * Math.sin(theta);
    };

    //opérations de calcul
    public ComplexNumber plus(ComplexNumber complex){
        CartesianComplexNumber newComplex = new CartesianComplexNumber(real+complex.getReal(), imaginary+complex.getImaginary());
        return newComplex;

    };
    public ComplexNumber minus(ComplexNumber complex){
        CartesianComplexNumber newComplex = new CartesianComplexNumber(real-complex.getReal(), imaginary-complex.getImaginary());
        return newComplex;
    };
    public ComplexNumber multiply(ComplexNumber complex){
        CartesianComplexNumber newComplex = new CartesianComplexNumber((real*complex.getReal()) - (imaginary*complex.getImaginary())
                                ,(real*complex.getImaginary()) +(imaginary*complex.getReal()));
        return newComplex;

    };
    public ComplexNumber conjugate(){
        CartesianComplexNumber newComplex = new CartesianComplexNumber(real, -imaginary);
        return newComplex;
    };

    public String toString(){
        return "("+real+" + i"+imaginary+")";
    }
}
