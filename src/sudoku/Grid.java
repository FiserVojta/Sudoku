/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author Vojtech
 */
public class Grid {
    private final Field[][] grid;
    private final int SIZE;

    public Grid(int SIZE) {
        this.SIZE = SIZE;
        grid = new Field[SIZE][SIZE];
        setFields();
    }
    
    public Field getFieldAt(int x, int y){
        return grid[x][y];
    }   
    
    
    private void setFields(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = new Field(i, j, this);
            }
        }
    }
    
}
