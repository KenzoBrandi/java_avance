package model;

public interface ComplexNumberChangeListener{

    /**
     * Invoked when the target of the listener has changed its state.
     * @param context The complex number that has changed.
     */
    public void stateChanged(EditableComplexNumber context);
}
