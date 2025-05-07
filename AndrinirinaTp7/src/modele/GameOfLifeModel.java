package modele;

import java.util.ArrayList;

public class GameOfLifeModel implements Subject{
    private boolean[][] grid;
    private ArrayList<Observer> observers;
    public GameOfLifeModel(int nbRows, int nbColumns){
        grid = new boolean[nbRows][nbColumns];
        observers = new ArrayList<Observer>();
    }
    public boolean[][] getGrid() {
        return grid;
    }
    public boolean getCellValue(int row, int column){
        return grid[row][column];
        
    }
    public void makeCellAlive(int row, int column){
        grid[row][column] = true;
    }
    public void killCell(int row, int column){
        grid[row][column] = false;
    }
    public int nbAliveNeighboringCells(int row, int column) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
    
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue; // ignorer la cellule elle-même
    
                int newRow = row + i;
                int newCol = column + j;
    
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    if (grid[newRow][newCol]) {
                        count++;
                    }
                }
            }
        }
    
        return count;
    }
    
    public void nextIteration(){
        boolean[][] newGrid = new boolean[grid.length][grid[0].length];
        int neighbors;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                neighbors = nbAliveNeighboringCells(i, j);
                if ( neighbors ==3 || // Nombre cellules voisines vivantes==3
                    (getCellValue(i, j) && neighbors ==2)){ //la cellule est vivante et le nombre de cellules voisines vivantes==2
                    newGrid[i][j]= true;
                } else {
                    newGrid[i][j]= false;
                }
            }
        }
        grid = newGrid;
        notifyObservers(this);
    }
    public void subscribe(Observer observer){
        if (observer != null) {
            observers.add(observer);
        }
    }
    public void unsubscribe(Observer observer){
        if (observer != null) {
            observers.remove(observer);
        }
    }
    public void notifyObservers(Object context){
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
