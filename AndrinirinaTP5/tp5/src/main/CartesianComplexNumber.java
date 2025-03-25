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
        if (real>=0) {
            return Math.asin(imaginary / getModulus());
        }
        return Math.PI - Math.asin(imaginary / getModulus());
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
