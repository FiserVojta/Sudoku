/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.ArrayList;
import java.util.List;

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

      grid.getFieldAt(0, 1).setValue(1);
         grid.getFieldAt(0, 2).setValue(2);

        grid.getFieldAt(0, 3).setValue(3);
        grid.getFieldAt(0, 4).setValue(4);
        grid.getFieldAt(0, 6).setValue(5);
        grid.getFieldAt(0, 5).setValue(6);
        grid.getFieldAt(2, 2).setValue(7);
        grid.getFieldAt(8, 3).setValue(8);
      

        grid.compute();
        //grid.getFieldAt(8, 8).print();
        grid.print();

    }

}
