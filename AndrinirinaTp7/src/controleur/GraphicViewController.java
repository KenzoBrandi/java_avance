package controleur;

import java.util.Scanner;

import modele.GameOfLifeModel;
import modele.Observer;
import modele.Subject;
import vue.GraphicView;

public class GraphicViewController implements Observer {
    private final GameOfLifeModel game;
    private final GraphicView view;
    public GraphicViewController(GameOfLifeModel game){
        this.game = game;
        game.subscribe(this);
        view = new GraphicView(game.getGrid());
    }

    @Override
    public void update(Subject s) {
        view.getPanel().setGrid(game.getGrid());
        view.getPanel().repaint();
        
    }

    public void start(){
        view.pack();
        view.setVisible(true);

        //attente d'une entrée utilisateur
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        //les itérations
        while (true){
            game.nextIteration();
            scanner.nextLine();
        }
    }
}
