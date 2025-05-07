import java.util.Random;

import controleur.ConsoleViewController;
import controleur.GraphicViewController;
import modele.GameOfLifeModel;
import vue.ConsoleView;
import vue.GraphicView;

public class App {
    public static void main(String[] args) throws Exception {
        int rows = 15;
        int cols = 15;
        GameOfLifeModel game = new GameOfLifeModel(rows, cols);
        int col;
        int row;
        Random random = new Random();
        for(int i=0; i<20; i++){
            row = random.nextInt(rows);
            col = random.nextInt(cols);
            game.makeCellAlive(row, col);
        }
        // ConsoleView consoleView = new ConsoleView();
        // ConsoleViewController consoleViewController = new ConsoleViewController(game, consoleView);
        // consoleViewController.start();
        GraphicViewController graphicViewController = new GraphicViewController(game);
        graphicViewController.start();
    }
}
