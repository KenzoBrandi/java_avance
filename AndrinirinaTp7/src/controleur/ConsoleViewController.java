package controleur;

import java.util.Scanner;

import modele.GameOfLifeModel;
import modele.Observer;
import modele.Subject;
import vue.ConsoleView;

public class ConsoleViewController implements Observer{
    private final GameOfLifeModel game;
    private ConsoleView consoleView;
    public ConsoleViewController(GameOfLifeModel game, ConsoleView consoleView){
        this.game = game;
        this.consoleView = consoleView;
        this.game.subscribe(this);

    }

    @Override
    public void update(Subject s){
        consoleView.print(game.getGrid());
    }

    public void start(){
        //initialisation de l'affichage
        consoleView.print(game.getGrid());
        
        //attente d'une entrée utilisateur
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        //les itérations
        while (true){
            game.nextIteration();
            scanner.nextLine();
            //attente de 500ms entre chaque étape
            // try {
            //     Thread.sleep(500);
            //     System.out.println("sqds");
            // } catch (Exception e){
            //     System.out.println(e.getMessage());
            // }
        }
        
    }
}
