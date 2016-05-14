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
public class Field implements Comparable<Field> {

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

    public void addToPosibilities(int number) {
        boolean check = true;
        for (int i = 0; i < posibilities.size(); i++) {
            if (posibilities.get(i) == number) {
                check = false;
            }
        }
        if (check && !used) {
            posibilities.add(number);
        }
    }

    public void setPosibilities() {
        posibilities = new ArrayList();
        for (int i = 1; i < 10; i++) {
            posibilities.add(i);
        }
        removePosibilitiesFromLine();
        removePosibilitiesFromColumn();
        removePosibilitiesFromSquare();
       

    }

    private void removePosibilitiesFromSquare() {
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

    private void removePosibilitiesFromColumn() {
        for (int i = 0; i < 9; i++) {           
                this.removeNumberFromPosibilities(grid.getFieldAt(i, Ycoordinate).getValue());            
        }
    }

    public void removeNumberFromPosibilities(int number) {
        for (int i = 0; i < posibilities.size(); i++) {
            if (posibilities.get(i) == number) {

                posibilities.remove(i);
                return;

            }
        }
    }

    public void print() {
        for (int i = 0; i < posibilities.size(); i++) {
            System.out.print(posibilities.get(i));
        }
        System.out.println("");
        System.out.println(Xcoordinate + " " + Ycoordinate);
    }

    public List<Integer> getPosibilities() {
        return posibilities;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        used = true;
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

    @Override
    public int compareTo(Field t) {
        return posibilities.size() - t.getPosibilities().size();
    }

    @Override
    public String toString() {
        return value + " ";
    }

    public int getXSquareCoordinate() {
        return XSquareCoordinate;
    }

    public int getYSquareCoordinate() {
        return YSquareCoordinate;
    }

    public int getXcoordinate() {
        return Xcoordinate;
    }

    public int getYcoordinate() {
        return Ycoordinate;
    }

}
