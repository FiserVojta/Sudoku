/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.List;

/**
 *
 * @author Vojtech
 */
public class Field {
    private int value;
    private List posibilities;
    private final int Xcoordinate;
    private final int Ycoordinate;
    private int XSquareCoordinate;
    private int YSquareCoordinate;
    private Grid grid;

    public Field(int Xcoordinate, int Ycoordinate, Grid grid) {
        this.Xcoordinate = Xcoordinate;
        this.Ycoordinate = Ycoordinate;
        this.grid = grid;
        setSquare();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }   
        
    private void setSquare(){
        for (int i = 0; i < 10; i=i+3) {
            for (int j = 0; j < 10; j=j+3) {
                if(Xcoordinate < i && Ycoordinate < j){
                    XSquareCoordinate = i -3;
                    YSquareCoordinate = j -3;
                    return;
                }
            }
        }
    }
    
}
