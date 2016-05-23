/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Vojtech
 */
public class NewGui extends JFrame{

    SudokuGrid grid;
    MenuGui menu;
    
    public static void main(String[] args) {
        NewGui gui = new NewGui();
    }
    
    public NewGui() {
        grid = new SudokuGrid();
        menu = new MenuGui(grid, this);
        
        this.setIconImage(new ImageIcon("znacek.png").getImage());
        this.setSize(550, 400);
        this.setResizable(false);
        this.setTitle("Sudoku Solver");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        
        this.add(grid);
        this.add(menu);
    }
    
    public void ha(){
        grid = new SudokuGrid();
    }
    
    
}
