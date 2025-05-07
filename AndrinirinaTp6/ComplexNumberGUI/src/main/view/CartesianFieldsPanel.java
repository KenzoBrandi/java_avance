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
 * Panel for cartesian fields edition.
 * TODO : Implements ComplexNumberChangeListener.
 */
public class CartesianFieldsPanel extends JPanel{

    /**
     * Text field for real value edition.
     */
    private JTextField realTextField;

    /**
     * Text field for imaginary value edition.
     */
    private JTextField imaginaryTextField;

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
    public CartesianFieldsPanel(ComplexNumberFrame parent, EditableComplexNumber editableComplexNumber){
        this.parent = parent;
        this.complexNumber = editableComplexNumber;
        
        // TODO : register panel to complex number listeners
        this.complexNumber.register(new ComplexNumberChangeListener() {
            @Override
            public void stateChanged(EditableComplexNumber context) {
                setFieldValues();
            }
        });

        // panel border and title
        setBorder(BorderFactory.createTitledBorder("Cartesian"));
        setBackground(ComplexNumberFrame.BACKGROUND);

        // panel layout
        setLayout(new GridLayout(2, 2, 10, 5));

        // components initialisation
        this.imaginaryTextField = new JTextField();
        this.realTextField = new JTextField();

        // adding components
        add(ComponentFactory.makeJLabel("Real : "));
        add(realTextField);
        add(ComponentFactory.makeJLabel("Imaginary : "));
        add(imaginaryTextField);
        realTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.setErrorMessage("");
                complexNumber.updateFromCartesian(CartesianFieldsPanel.this.getRealValue(), CartesianFieldsPanel.this.getImaginaryValue());
            }
        });
        imaginaryTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.setErrorMessage("");
                complexNumber.updateFromCartesian(CartesianFieldsPanel.this.getRealValue(), CartesianFieldsPanel.this.getImaginaryValue());
            }
        });
        
        setFieldValues();
    }

    /**
     * Updates fields values from model (complex number).
     */
    private void setFieldValues(){
        this.realTextField.setText(String.format(Locale.US, "%.3f", complexNumber.getReal()));
        this.imaginaryTextField.setText(String.format(Locale.US, "%.3f", complexNumber.getImaginary()));
    }

    /**
     * Give the double value currently displayed in the real text field
     * 
     * @return the double value
     * @throws NumberFormatException if the text has not a valid format
     */
    private double getRealValue() throws NumberFormatException
    {   
        Double realValue = 0.0;
        String value = this.realTextField.getText();
        try {
            realValue = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            parent.setErrorMessage("Incorrect argument value "+value);

        }
        return realValue;
        
    }

    /**
     * Give the double value currently displayed in the imaginary text field
     * 
     * @return the double value
     * @throws NumberFormatException if the text has not a valid format
     */
    private double getImaginaryValue() throws NumberFormatException
    {
        Double imaginaryValue = 0.0;
        String value = this.imaginaryTextField.getText();
        try {
            imaginaryValue = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            parent.setErrorMessage("Incorrect argument value "+value);
            
        }
        return imaginaryValue;
    }

    /**
     * Give the string value currently displayed in the real text field
     * 
     * @return the string value
     */
    private String getRealText()
    {
        return this.realTextField.getText();
    }

    /**
     * Give the string value currently displayed in the imaginary text field
     * 
     * @return the string value
     */
    private String getImaginaryText()
    {
        return this.imaginaryTextField.getText();
    }
}
