package vue;

public class ConsoleView{
    public void print(boolean[][] grid ){
        System.out.println("\033[H\033[2J");
        for (int i=0; i<grid.length; i++){
            System.out.print("_");
        }
        System.out.println();
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (grid[i][j]){
                    System.out.print("\u2B1C");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("|");
            System.out.println("");
        }
        for (int i=0; i<grid.length; i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
