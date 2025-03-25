import cardgame.*;

public class App {
    public static void main(String[] args) {
        Battle battle = new Battle(GameType.CARD32);
        battle.play();
    }
}
