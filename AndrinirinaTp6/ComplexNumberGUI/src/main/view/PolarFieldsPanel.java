package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.ComplexNumberChangeListener;
import model.EditableComplexNumber;

/**
 * Panel for polar edition.
 * TODO : Implements ComplexNumberChangeListener.
 */
public class PolarFieldsPanel extends JPanel{

    /**
     * Text field for modulus value edition.
     */
    private JTextField modulusTextField;

    /**
     * Text field for argument value edition.
     */
    private JTextField argumentTextField;

    /**
     * The complex number, model in the MVC settings.
     */
    private final EditableComplexNumber complexNumber;

    /**
     * The parent of the panel.
     */
    private ComplexNumberFrame parent;

    /**
     * Constructor.
     * @param parent                The parent of the panel.
     * @param editableComplexNumber The complex number, model in the MVC settings.
     */
    public PolarFieldsPanel(ComplexNumberFrame parent, EditableComplexNumber editableComplexNumber){
        this.parent = parent;
        this.complexNumber = editableComplexNumber;
        // TODO : register panel to complex number listeners
        complexNumber.register(new ComplexNumberChangeListener() {
            @Override
            public void stateChanged(EditableComplexNumber context) {
                setFieldValues();
            }
        });

        // panel border and title
        setBorder(BorderFactory.createTitledBorder("Polar"));
        setBackground(ComplexNumberFrame.BACKGROUND);

        // panel layout
        setLayout(new GridLayout(2, 2, 10, 5));

        // components initialisation
        argumentTextField = new JTextField();
        modulusTextField = new JTextField();
        
        // adding components
        add(ComponentFactory.makeJLabel("Modulus : "));
        add(modulusTextField);
        add(ComponentFactory.makeJLabel("Argument : "));
        add(argumentTextField);

        // TODO: add listeners to the textfields
        modulusTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.setErrorMessage("");
                complexNumber.updateFromPolar(getModulusValue(), getArgumentValue());
            }
        });
        argumentTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.setErrorMessage("");
                complexNumber.updateFromPolar(getModulusValue(), getArgumentValue());
            }
        });
        
        setFieldValues();
    }

    /**
     * Updates fields values from model (complex number).
     */
    private void setFieldValues(){
        if (this.complexNumber != null){
            this.modulusTextField.setText(String.format(Locale.US, "%.3f", complexNumber.getModulus()));
            this.argumentTextField.setText(String.format(Locale.US, "%.3f", complexNumber.getArgument()));
        }
    }

    /**
     * Give the double value currently displayed in the modulus text field
     * 
     * @return the double value
     * @throws NumberFormatException if the text has not a valid format
     */
    private double getModulusValue() throws NumberFormatException
    {
        Double modulusValue = 0.0;
        String value = this.modulusTextField.getText();
        try {
            modulusValue = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            parent.setErrorMessage("Incorrect argument value "+value);
        }
        return modulusValue;
    }

    /**
     * Give the double value currently displayed in the imaginary text field
     * 
     * @return the double value
     * @throws NumberFormatException if the text has not a valid format
     */
    private double getArgumentValue() throws NumberFormatException
    {
        Double argumentValue = 0.0;
        String value = this.argumentTextField.getText();
        try {
            argumentValue = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            parent.setErrorMessage("Incorrect argument value "+value);
        }
        return argumentValue;
    }

    /**
     * Give the string value currently displayed in the modulus text field
     * 
     * @return the string value
     */
    private String getModulusText()
    {
        return this.modulusTextField.getText();
    }

    /**
     * Give the string value currently displayed in the argument text field
     * 
     * @return the string value
     */
    private String getArgumentText()
    {
        return this.argumentTextField.getText();
    }
}
