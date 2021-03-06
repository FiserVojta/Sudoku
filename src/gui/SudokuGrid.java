/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import sudoku.Field;
import sudoku.Grid;

/**
 *
 * @author Vojtech
 */
public class SudokuGrid extends JPanel {

    private boolean computable;
    private Grid grid;
    private JTextField[][] array;
    private Dimension dim = new Dimension(350, 350);

    public SudokuGrid() {
        grid = new Grid(9);
        computable = true;
        
        this.setLayout(new GridLayout(9, 9));
        this.setPreferredSize(dim);

        array = new JTextField[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                array[i][j] = new JTextField(1);
                array[i][j].setHorizontalAlignment((int) CENTER_ALIGNMENT);
                this.add(array[i][j]);
                setColor(i, j);
            }
        }
    }
 
    
    
    private void setColor(int x, int y){
        Field field = grid.getFieldAt(x, y);
        int decider = (field.getXSquareCoordinate() + field.getYSquareCoordinate());
        if(decider%2==0){
            array[x][y].setBackground(Color.gray);
        }
           
    }

    public void compute() {
        readInput();
        if (computable) {
            grid.compute();
            writeInput();
        }
        computable = true;
        grid = new Grid(9);
    }
    
    

    public void readInput() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                try {
                    String str = array[i][j].getText();
                    int x = Integer.parseInt(str);
                    if (grid.setValueToField(i, j, x)) {
                        array[i][j].setBackground(Color.GREEN);
                    } else {
                        array[i][j].setBackground(Color.RED);
                        //grid.setValueToField(i, j, 0);
                        computable = false;
                    }

                } catch (Exception e) {

                }

            }
        }
    }

    public void writeInput() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String str = String.valueOf(grid.getValueAt(i, j));
                array[i][j].setText(str);
            }
        }
    }
}
