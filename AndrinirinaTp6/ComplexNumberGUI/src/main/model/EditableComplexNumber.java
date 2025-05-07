package model;

import java.util.ArrayList;
import complexnumber.ComplexNumber;

/**
 * Class representing the Model in MVC settings of complex number.
 * TODO: Complete the class for subscription management.
 */
public class EditableComplexNumber{
    /**
     *  List of its listeners
     *  */   
    private ArrayList<ComplexNumberChangeListener> listeners;

    /**
     * The complex number calculation logic.
     */
    private final ComplexNumber complexNumber;

    /**
     * A Complex number for calculation logic.
     * @param complexNumber The complex number.
     */



    public EditableComplexNumber(ComplexNumber complexNumber){
        this.complexNumber = complexNumber;
        listeners = new ArrayList<ComplexNumberChangeListener>();
    }

    /**
     * Method for registering change listeners (observers).
     * @param changeListener The change listeners.
     */
    public void register(ComplexNumberChangeListener changeListener){
        listeners.add(changeListener);
    }

    /**
     * Method for unregistering change listeners (observers).
     * @param changeListener
     */
    public void unregister(ComplexNumberChangeListener changeListener){
        listeners.remove(changeListener);
    }

    /**
     * Method to notify all the change listeners.
     */
    public void notifyListeners(){
        for (ComplexNumberChangeListener listener: listeners){
            listener.stateChanged(this);
        }
    }

    /**
     * Method to get real value (delegation).
     * @return The real value of the complex number.
     */
    public double getReal(){
        return this.complexNumber.getReal();
    }

    /**
     * Method to get imaginary value (delegation).
     * @return The imaginary value of the complex number.
     */
    public double getImaginary(){
        return this.complexNumber.getImaginary();
    }

    /**
     * Method to get modulus value (delegation).
     * @return The modulus value of the complex number.
     */
    public double getModulus(){
        return this.complexNumber.getModulus();
    }

    /**
     * Method to get argument value (delegation).
     * @return The argument value of the complex number.
     */
    public double getArgument(){
        return this.complexNumber.getArgument();
    }

    @Override
    public String toString() {
        return this.complexNumber.toString();
    }

    /**
     * Method to update complex number from polar values.
     * Notifies all the listeners.
     * @param modulus The modulus value.
     * @param argument The argument value.
     */
    public void updateFromPolar(double modulus, double argument){
        this.complexNumber.setPolar(modulus, argument);
        this.notifyListeners();
    }

    /**
     * Method to update complex number from cartesian values.
     * Notifies all the listeners.
     * @param real
     * @param imaginary
     */
    public void updateFromCartesian(double real, double imaginary){
        this.complexNumber.setCartesian(real, imaginary);
        this.notifyListeners();
    }
}