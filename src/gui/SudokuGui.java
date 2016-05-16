/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import sudoku.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Vojtech
 */
public class SudokuGui extends JFrame {

    Grid grid;
    JPanel mainPanel;
    JPanel meunPanel;
    JPanel sudokuPanel;
    JTextField[][] array;

    public static void main(String[] args) {
        new SudokuGui();
    }

    public SudokuGui() {
        grid = new Grid();
        
        this.setSize(500, 400);
        this.setResizable(false);
        this.setTitle("Sudoku Solver");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        mainPanel = new JPanel(new GridLayout(1, 2));
        meunPanel = new JPanel();
        sudokuPanel = new JPanel(new GridLayout(9, 9));

        mainPanel.setSize(400, 500);

        sudokuPanel.setSize(400, 400);
        mainPanel.setSize(100, 400);

        array = new JTextField[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                array[i][j] = new JTextField(1);
                array[i][j].setSize(40, 40);
                sudokuPanel.add(array[i][j]);
            }
        }
        JButton tlacitko = new JButton("zmackni me");
        meunPanel.add(tlacitko);
        mainPanel.add(sudokuPanel);
        mainPanel.add(meunPanel);
        this.add(mainPanel);
        this.setVisible(true);
        tlacitko.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               readInput();
               grid.compute();
               writeInput();
                
                
                
            }
        });
    }

    public void readInput() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                try {
                    String str = array[i][j].getText();
                    int x = Integer.parseInt(str);
                    grid.setValueToField(i, j, x);
                } catch (Exception e) {

                }

            }
        }
    }
    
    
    public void writeInput(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String str = String.valueOf(grid.getValueAt(i, j));
                array[i][j].setText(str);
            }
        }
    }

}
