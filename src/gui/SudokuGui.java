/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Vojtech
 */
public class SudokuGui extends JFrame {

    public static void main(String[] args) {
        new SudokuGui();
    }

    public SudokuGui() {
        this.setSize(400, 400);
        this.setTitle("Sudoku Solver");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel thePanel = new JPanel(new GridLayout(9, 9));
        JTextField[][] array = new JTextField[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                array[i][j] = new JTextField(1);
                thePanel.add(array[i][j]);
            }
        }
        
        this.add(thePanel);
        this.setVisible(true);
    }

}
