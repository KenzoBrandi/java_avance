package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.EditableComplexNumber;

public class ComplexNumberFrame extends JFrame{

    /**
     * Color for background. Used by various component for consistency.
     */
    public static final Color BACKGROUND = Color.WHITE;

    /**
     * The complex number to display. It represents the model in MVC.
     */
    private final EditableComplexNumber complexNumber;

    /**
     * Panel for expression display and field edition.
     */
    private ComplexNumberPanel editionPanel;

    /**
     * Panel for graphical representation of the complex number.
     */
    private GraphicComplexNumberPanel graphicPanel;

    /**
     * Label for displaying error messages.
     */
    private final JLabel errorDisplay;

    /**
     * Constructor.
     * @param title         The title of the frame.
     * @param complexNumber The complex nomber to display.
     */
    public ComplexNumberFrame(String title, EditableComplexNumber editableComplexNumber){
        this.complexNumber = editableComplexNumber;

        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.WHITE);

        // add panels
        this.editionPanel = new ComplexNumberPanel(this, this.complexNumber);
        add(editionPanel, BorderLayout.NORTH);

        this.graphicPanel = new GraphicComplexNumberPanel(this.complexNumber);
        add(graphicPanel, BorderLayout.CENTER);

        // create and add the error display panel.
        this.errorDisplay = new JLabel(" ");
        errorDisplay.setBackground(BACKGROUND);
        errorDisplay.setForeground(Color.RED);
        JPanel errorPanel = new JPanel();
        errorPanel.setBackground(BACKGROUND);
        errorPanel.add(errorDisplay);
        add(errorPanel, BorderLayout.SOUTH);
        
        // Add space labels for left and right margins.
        add(ComponentFactory.makeJLabel("     "), BorderLayout.EAST);
        add(ComponentFactory.makeJLabel("     "), BorderLayout.WEST);
    }

    /**
     * Method for displaying errors on the frame.
     * @param message The error message to display.
     */
    public void setErrorMessage(String message){
        this.errorDisplay.setText(message);
    }

    /**
     * Method for clearing errors.
     */
    public void clearErrorMessage(){
        this.errorDisplay.setText(" ");
    }
}
