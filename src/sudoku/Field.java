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
    //private final int SIZE;
    
    public Field(int Xcoordinate, int Ycoordinate, Grid grid) {
        this.Xcoordinate = Xcoordinate;
        this.Ycoordinate = Ycoordinate;
        this.grid = grid;
        posibilities = new ArrayList();
        used = false;
        setSquare();

    }

    /**
     *Sets all valid posibilities for this field.
     */
    public void setPosibilities() {
        posibilities = new ArrayList();
        for (int i = 1; i < grid.getSIZE()+1 ; i++) {
            posibilities.add(i);
        }
        removePosibilitiesFromLine();
        removePosibilitiesFromColumn();
        removePosibilitiesFromSquare();
       

    }

    private void removePosibilitiesFromSquare() {
        for (int i = 0; i < grid.getSQRSIZE(); i++) {
            for (int j = 0; j < grid.getSQRSIZE(); j++) {                
                    this.removeNumberFromPosibilities(grid.getFieldAt(XSquareCoordinate + i, YSquareCoordinate + j).getValue());               
            }
        }
    }

    private void removePosibilitiesFromLine() {
        for (int i = 0; i < grid.getSIZE(); i++) {            
                this.removeNumberFromPosibilities(grid.getFieldAt(Xcoordinate, i).getValue());           
        }
    }

    private void removePosibilitiesFromColumn() {
        for (int i = 0; i < grid.getSIZE(); i++) {           
                this.removeNumberFromPosibilities(grid.getFieldAt(i, Ycoordinate).getValue());            
        }
    }

    /**
     *  Removes given posibiliti from list
     * @param number value of posibility to remove
     */
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

    /**
     *  Return list of all posibilities
     * @return list of posibilities
     */
    public List<Integer> getPosibilities() {
        return posibilities;
    }

    /**
     * finds out if this field is used int sudoku
     * 
     * @return if is already filled
     */
    public boolean isUsed() {
        return used;
    }

    /**
     *
     * @param used
     */
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
        for (int i = 0; i < grid.getSIZE() + 1; i = i + grid.getSQRSIZE()) {
            for (int j = 0; j < grid.getSIZE() + 1; j = j + grid.getSQRSIZE()) {
                if (Xcoordinate < i && Ycoordinate < j) {
                    XSquareCoordinate = i - grid.getSQRSIZE();
                    YSquareCoordinate = j - grid.getSQRSIZE();
                    return;
                }
            }
        }
    }

    /**
     *
     * @param t
     * @return
     */
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
