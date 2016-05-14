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

    public Grid() {
        solved = false;
        queue = new PriorityQueue<>();
        this.grid = new Field[9][9];
        setField();
    }

    public void compute() {
        computeAllPosibilities();
        System.out.println("  as" + queue.size() + " aa ");
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
                computeAllPosibilities();
                print();
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
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = new Field(i, j, this);
                queue.add(grid[i][j]);
            }
        }
    }

    public void computeAllPosibilities() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j].setPosibilities();
                //queue.add(grid[i][j]);
            }
        }
    }

    public Field getFieldAt(int x, int y) {
        return grid[x][y];
    }

    public void print() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }

}
