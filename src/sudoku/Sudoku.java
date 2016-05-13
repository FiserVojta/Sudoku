/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author Vojtech
 */
public class Sudoku {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Grid grid = new Grid(9);
       grid.getFieldAt(0, 0).setValue(2);
       grid.getFieldAt(0, 6).setValue(6);
       grid.getFieldAt(5, 1).setValue(7);
       grid.getFieldAt(8, 1).setValue(8);
       grid.getFieldAt(4, 4).setValue(1);       
       //grid.getFieldAt(5, 5).setPosibilities();
       //grid.getFieldAt(5, 5).print();
       grid.compute();
    }
    
}
