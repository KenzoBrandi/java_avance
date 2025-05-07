package vue;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class MyPanel extends JPanel{
    private boolean[][] grid;
    private static final int UNIT = 20;
    public MyPanel(boolean[][] grid){
        this.grid = grid;
        setBackground(Color.DARK_GRAY);
        setSize(1000, 800);
    }

    public void setGrid(boolean[][] grid) {
        this.grid = grid;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i =0 ; i<grid.length; i++){
            for (int j =0 ; j<grid.length; j++){
                if (grid[i][j]){
                    g.setColor(Color.WHITE);
                    
                }else {
                    g.setColor(Color.BLACK);
                }
                g.fillRect(i*UNIT + 1, j*UNIT+ 1, UNIT, UNIT);
            }
        }

    }
}
