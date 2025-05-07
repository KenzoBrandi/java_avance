package vue;
import javax.swing.JFrame;


public class GraphicView extends JFrame{
    private final MyPanel panel;
    public GraphicView(boolean[][] grid){
        //Frame initialisation
        setTitle("Game of Life");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 800);

        // add panel
        panel = new MyPanel(grid);
        add(panel);
    }

    public MyPanel getPanel() {
        return panel;
    }

}
