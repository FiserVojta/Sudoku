/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Vojtech
 */
public class Grid {

    private boolean solved;
    private PriorityQueue<Field> queue;
    private final Field[][] grid;
    private final int SIZE;
    private final int SQRSIZE;
    
    public Grid(int size) {
        this.SIZE = size;
        this.SQRSIZE = (int) Math.sqrt(size);
        solved = false;
        queue = new PriorityQueue<>();
        this.grid = new Field[SIZE][SIZE];
        setField();
    }

    /**
     *Completes all non used field if is posible
     */
    public void compute() {
        computeAllPosibilities();
        rekurze();
    }

    private void rekurze() {
        if (queue.isEmpty()) {
            solved = true;
            return;
        }
        Field field = queue.poll();
        List<Integer> list = field.getPosibilities();
        for (int i = 0; i < list.size(); i++) {
            if (!solved) {
                int value = list.get(i);
                field.setValue(value);
                computePosibilitiesAroundOneField(field);
                rekurze();
            }
        }
        if (!solved) {
            field.setValue(0);
            field.setUsed(false);
            queue.add(field);
        }
    }

    private void setField() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = new Field(i, j, this);
                //queue.add(grid[i][j]);
            }
        }
    }

    public void computeAllPosibilities() {
        queue = new PriorityQueue<>();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (!grid[i][j].isUsed()) {
                    grid[i][j].setPosibilities();
                    queue.add(grid[i][j]);
                }
            }
        }
    }

    public Field getFieldAt(int x, int y) {
        return grid[x][y];
    }

    public void print() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public void removeFromQueue(Field field) {
        queue.remove(field);
    }

    public void addToQueue(Field field) {
        queue.add(field);
    }

    public boolean setValueToField(int x, int y, int value) {
        if (isPosible(x, y, value)) {
            grid[x][y].setValue(value);
            return true;
        } else {
            return false;
        }
    }

    public int getValueAt(int x, int y) {
        return grid[x][y].getValue();

    }
    
    public void setUnUsed(int x, int y){
        grid[x][y].setUsed(false);
    }

    public boolean isPosible(int x, int y, int value) {
        if (value < 1 || value > SIZE) {
            return false;
        }
        for (int i = 0; i < SIZE; i++) {
            if (grid[x][i].getValue() == value || grid[i][y].getValue() == value) {
                return false;
            }
        }
        for (int i = 0; i < SQRSIZE; i++) {
            for (int j = 0; j < SQRSIZE; j++) {
                if (grid[i + grid[x][y].getXSquareCoordinate()][j + grid[x][y].getYSquareCoordinate()].getValue() == value) {
                    return false;
                }
            }
        }
        return true;
    }

    private void computePosibilitiesAroundOneField(Field field) {
        for (int i = 0; i < SIZE; i++) {
            updateOneField(grid[i][field.getYcoordinate()]);
            updateOneField(grid[field.getXcoordinate()][i]);
        }
        for (int i = 0; i < SQRSIZE; i++) {
            for (int j = 0; j < SQRSIZE; j++) {
                updateOneField(grid[field.getXSquareCoordinate() + i][field.getYSquareCoordinate() + j]);
            }

        }
    }

    private void updateOneField(Field field) {
        if (!field.isUsed()) {
            queue.remove(field);
            field.setPosibilities();
            queue.add(field);
        }
    }

    public int getSIZE() {
        return SIZE;
    } 

    public int getSQRSIZE() {
        return SQRSIZE;
    }
    

}
