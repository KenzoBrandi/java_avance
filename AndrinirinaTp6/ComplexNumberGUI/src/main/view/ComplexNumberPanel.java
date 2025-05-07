package view;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;

import model.ComplexNumberChangeListener;
import model.EditableComplexNumber;

import java.awt.Component;
import java.awt.GridLayout;
/**
 * Panel for complex number representation and edition.
 * TODO : Implements ComplexNumberChangeListener.
 */
public class ComplexNumberPanel extends JPanel{

    /**
     * A JLabel to display the expression.
     */
    private JLabel displayLabel;

    /**
     * A panel for cartesian values text fields.
     */
    private CartesianFieldsPanel cartesianFieldsPanel;

    /**
     * A panel for polar values text fields.
     */
    private PolarFieldsPanel polarFieldsPanel;

    /**
     * The complex number to manipulate (the Model in MVC settings)
     */
    private final EditableComplexNumber complexNumber;

    /**
     * The frame parent of this panel.
     */
    private final ComplexNumberFrame parent;

    /**
     * Constructor
     * @param parent The parent frame of this panel.
     * @param editableComplexNumber The complex number (model in MVC settings)
     */
    public ComplexNumberPanel(ComplexNumberFrame parent, EditableComplexNumber editableComplexNumber){
        this.complexNumber = editableComplexNumber;
        // TODO : register this panel to the complex number listeners
        complexNumber.register(new ComplexNumberChangeListener() {
            @Override
            public void stateChanged(EditableComplexNumber context) {
                updateDisplay();
            }
        });
        
        this.parent = parent;
        // panel title
        this.setBorder(
            new CompoundBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5),
                BorderFactory.createTitledBorder("Display and Edition")));
        setBackground(ComplexNumberFrame.BACKGROUND);

        // components initialisation
        this.displayLabel = new JLabel("");
        this.cartesianFieldsPanel = new CartesianFieldsPanel(this.parent, complexNumber);
        this.polarFieldsPanel = new PolarFieldsPanel(parent, complexNumber);

        // layout manager
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // creating display panel
        JPanel displayPanel = new JPanel();
        displayPanel.setBackground(ComplexNumberFrame.BACKGROUND);
        displayPanel.setBorder(BorderFactory.createTitledBorder("Expression"));
        displayLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        displayPanel.add(displayLabel);

        // adding sub panels
        // display panel
        this.add(displayPanel);
        this.add(ComponentFactory.makeHorizontalEmptyBox());

        // A panel for grid display of cartesian and polar fields panels
        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setBackground(ComplexNumberFrame.BACKGROUND);
        fieldsPanel.setLayout(new GridLayout(1, 2, 10, 5));
        fieldsPanel.add(cartesianFieldsPanel);
        fieldsPanel.add(polarFieldsPanel);
        this.add(fieldsPanel);

        updateDisplay();
    }

    /**
     * Method for updating the display label.
     */
    private void updateDisplay(){
        if(this.complexNumber != null)
            this.displayLabel.setText(this.complexNumber.toString());
    }
}
