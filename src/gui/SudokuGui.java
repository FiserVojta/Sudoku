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

    Dimension dmn = new Dimension(350, 350);
    Grid grid;
    JPanel mainPanel;
    JPanel menuPanel;
    JPanel sudokuPanel;
    JTextField[][] array;

    public static void main(String[] args) {
        SudokuGui sudokuGui = new SudokuGui();
    }

    public SudokuGui() {
        grid = new Grid();

        this.setSize(550, 400);
        this.setResizable(false);
        this.setTitle("Sudoku Solver");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        mainPanel = new JPanel(new FlowLayout());
        mainPanel.setSize(new Dimension(550, 400));

        menuPanel = new JPanel();
        JButton tlacitko = new JButton("Vypocitej");
        menuPanel.add(tlacitko);

        sudokuPanel = new JPanel(new GridLayout(9, 9));

        sudokuPanel.setPreferredSize(dmn);
        sudokuPanel.setMaximumSize(dmn);
        sudokuPanel.setMinimumSize(dmn);

        array = new JTextField[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                array[i][j] = new JTextField(1);
                sudokuPanel.add(array[i][j]);
            }
        }

        mainPanel.add(sudokuPanel);
        mainPanel.add(menuPanel);

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
                    if (x > 0) {
                        array[i][j].setBackground(Color.GREEN);
                    }
                    grid.setValueToField(i, j, x);
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
