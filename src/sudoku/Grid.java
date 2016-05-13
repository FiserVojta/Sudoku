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

    private final Field[][] grid;
    private final int SIZE;
    private PriorityQueue<Field> queue;

    public Grid(int SIZE) {
        this.SIZE = SIZE;
        grid = new Field[SIZE][SIZE];
        setFields();
        queue = new PriorityQueue<>(SIZE * SIZE);
    }

    public Field getFieldAt(int x, int y) {
        return grid[x][y];
    }

    public void compute() {
        setPosibilities();
        recursion();
    }

    public void recursion() {
        if (!queue.isEmpty()) {
            Field field = queue.poll();
            List<Integer> list = field.getPosibilities();
            for (int i = 0; i < list.size(); i++) {
                field.setValue(list.get(i));
                updatePosibilities(field, list.get(i));
                recursion();
            }
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

    public void print() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    private void updatePosibilities(Field field, int value) {
        UpdatePosibilitiesInLine(field.getXcoordinate(), value);
        UpdatePosibilitiesInColumn(field.getYcoordinate(), value);
        UpdatePosibilitiesInSquare(field.getXSquareCoordinate(), field.getYSquareCoordinate(), value);
    }

    private void UpdatePosibilitiesInLine(int line, int number) {
        for (int i = 0; i < SIZE; i++) {
            grid[line][i].removeNumberFromPosibilities(number);
        }
    }
    
    private void UpdatePosibilitiesInColumn(int column, int number) {
        for (int i = 0; i < SIZE; i++) {
            grid[i][column].removeNumberFromPosibilities(number);
        }
    }
    
    private void UpdatePosibilitiesInSquare(int x, int y, int value){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[x+i][y+j].removeNumberFromPosibilities(value);
            }
        }
    }

}
