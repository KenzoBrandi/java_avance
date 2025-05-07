package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.ComplexNumberChangeListener;
import model.EditableComplexNumber;

/**
 * Panel for graphical representation of complex number.
 */
public class GraphicComplexNumberPanel extends JPanel implements ComplexNumberChangeListener{
    /**
     * Value of radius for markings in pixel.
     */
    private static final int RADIUS = 4;

    /**
     * Unit value for the orthonormal cordinate system in pixel.
     */
    private static final int UNIT = 20;

    /**
     * The complex number to listen to.
     */
    private final EditableComplexNumber complexNumber;

    /**
     * Constructor.
     * @param editableComplexNumber The complex number, model in MVC.
     */
    public GraphicComplexNumberPanel(EditableComplexNumber editableComplexNumber){
        this.complexNumber = editableComplexNumber;
        this.complexNumber.register(this);
        setPreferredSize(new Dimension(401, 401));
        setBackground(ComplexNumberFrame.BACKGROUND);
    }

    /**
     * Method invoked each time the panel is painted, either
     * by the GUI system, or by the {@link #repaint()} method
     * invocation.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // the number of markings of the units per axis
        int xunits = (int)(getWidth()/UNIT);
        int yunits = (int)(getHeight()/UNIT);
        
        // the location (x,y) of the center in pixels
        int originX = getWidth()/2;
        int originY = getHeight()/2;

        // draw the axes and the unit markings
        // x axis
        g.drawLine(0, originY, getWidth(), originY);
        // y axis
        g.drawLine(originX, 0, originX, getHeight());
        // x axis unit markings
        for (int i=1; i<xunits/2+1; i+=1) {
            // gray lines
            g.setColor(Color.LIGHT_GRAY);
            g.drawLine(originX+i*UNIT, 0, originX+i*UNIT, getHeight());
            g.drawLine(originX-i*UNIT, 0, originX-i*UNIT, getHeight());

            // black markings on axis
            g.setColor(Color.BLACK);
            g.drawLine(originX+i*UNIT, originY-RADIUS, originX+i*UNIT, originY+RADIUS);
            g.drawLine(originX-i*UNIT, originY-RADIUS, originX-i*UNIT, originY+RADIUS);
        }
        // y axis unit markings
        for (int i=1; i<yunits/2+2; i+=1) {
            // gray lines
            g.setColor(Color.LIGHT_GRAY);
            g.drawLine(0, originY-i*UNIT, getHeight(), originY-i*UNIT);
            g.drawLine(0, originY+i*UNIT, getHeight(), originY+i*UNIT);

            // black markings on axis
            g.setColor(Color.BLACK);
            g.drawLine(originX-RADIUS, originY-i*UNIT, originX+RADIUS, originY-i*UNIT);
            g.drawLine(originX-RADIUS, originY+i*UNIT, originX+RADIUS, originY+i*UNIT);
        }
        
        // TODO: draw the point representing the complex number
        g.setColor(Color.RED);
        g.fillOval(originX + (int)(complexNumber.getReal()*UNIT) -3,originY - (int)(complexNumber.getImaginary()*UNIT) -3, 6, 6);
    }

    @Override
    public void stateChanged(EditableComplexNumber context) {
        repaint();        
    }
}
