/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import sudoku.Grid;

/**
 *
 * @author Vojtech
 */
public class MenuGui extends JPanel{
    
    Dimension dim = new Dimension(150, 150);
    SudokuGrid grid;
    JFrame rames;
    
    
    public MenuGui(SudokuGrid grid, JFrame ramec) {
        this.setPreferredSize(dim);
        this.grid = grid;
        this.rames = ramec;
        
        
        JButton compute = new JButton("Vypocitej");
        JButton newSudoku = new JButton("Novy pokus");
        this.add(compute);
        this.add(newSudoku);
        
        compute.addActionListener((ActionEvent ae) -> {
            
            grid.compute();
        });

        newSudoku.addActionListener((ActionEvent ae) -> {
            rames.dispose();
            new NewGui();
        });
    }
    
    
    
}
