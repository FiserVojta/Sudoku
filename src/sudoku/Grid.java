/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.PriorityQueue;

/**
 *
 * @author Vojtech
 */
public class Grid {

    private final Field[][] grid;
    private final int SIZE;
    private PriorityQueue<Field> queue;

    public Grid(int SIZE) {
        this.SIZE = SIZE;
        grid = new Field[SIZE][SIZE];
        setFields();
        queue = new PriorityQueue<>(SIZE*SIZE);
    }

    public Field getFieldAt(int x, int y) {
        return grid[x][y];
    }

    public void compute() {
        setPosibilities();
        while(!queue.isEmpty()){
            queue.poll().print();
        }
    }

    private void setPosibilities() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (!grid[i][j].isUsed()) {
                    grid[i][j].setPosibilities();
                    queue.add(grid[i][j]);
                }
            }
        }
    }

    private void setFields() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = new Field(i, j, this);                
            }
        }
    }

}
