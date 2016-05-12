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
public class Field {

    private int value;
    private List<Integer> posibilities;
    private final int Xcoordinate;
    private final int Ycoordinate;
    private int XSquareCoordinate;
    private int YSquareCoordinate;
    private final Grid grid;
    private boolean used;

    public Field(int Xcoordinate, int Ycoordinate, Grid grid) {
        this.Xcoordinate = Xcoordinate;
        this.Ycoordinate = Ycoordinate;
        this.grid = grid;
        posibilities = new ArrayList();
        used = false;
        setSquare();
        
    }

    public void setPosibilities() {
        System.out.println(XSquareCoordinate + " " + YSquareCoordinate);
        for (int i = 0; i < 9; i++) {
            posibilities.add(i + 1);
        }
        removePosibilitiesFromLine();
        removePosibilitiesFromColumn();
        removePosibilitiesFromSquare();
    }

    private void removePosibilitiesFromSquare(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.removeNumberFromPosibilities(grid.getFieldAt(XSquareCoordinate + i, YSquareCoordinate + j).getValue());
            }
        }
    }
    
    private void removePosibilitiesFromLine() {
        for (int i = 0; i < 9; i++) {
            this.removeNumberFromPosibilities(grid.getFieldAt(Xcoordinate, i).getValue());
        }
    }
    
    private void removePosibilitiesFromColumn(){
         for (int i = 0; i < 9; i++) {
            this.removeNumberFromPosibilities(grid.getFieldAt(i, Ycoordinate).getValue());
        }
    }

    private void removeNumberFromPosibilities(int number) {
        for (int i = 0; i < posibilities.size(); i++) {
            if(posibilities.get(i) == number){
                posibilities.remove(i);
                return;
            }
        }
    }
    
    public void print(){
        for (int i = 0; i < posibilities.size(); i++) {
            System.out.print(posibilities.get(i));
        }
        System.out.println("");
    }

    public List<Integer> getPosibilities() {
        return posibilities;
    }   
    
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private void setSquare() {
        for (int i = 0; i < 10; i = i + 3) {
            for (int j = 0; j < 10; j = j + 3) {
                if (Xcoordinate < i && Ycoordinate < j) {
                    XSquareCoordinate = i - 3;
                    YSquareCoordinate = j - 3;
                    return;
                }
            }
        }
    }

}
