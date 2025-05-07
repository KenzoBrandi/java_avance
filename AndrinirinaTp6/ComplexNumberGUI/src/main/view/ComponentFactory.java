package view;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JLabel;

public class ComponentFactory {

    /**
     * Creates a configured JLabel with a given text.
     * @param text The text of the label.
     * @return The configured JLabel.
     */
    public static JLabel makeJLabel(String text){
        JLabel label = new JLabel(text);
        label.setOpaque(true);
        label.setBackground(ComplexNumberFrame.BACKGROUND);
        return label;
    }

    /**
     * Creates an empty horizontal box for vertical spacing.
     * @return Component representing the horizontal box.
     */
    public static Component makeHorizontalEmptyBox(){
        Component box = Box.createRigidArea(new Dimension(0, 10));
        box.setBackground(ComplexNumberFrame.BACKGROUND);
        return box;
    }
}
