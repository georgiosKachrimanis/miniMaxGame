
package com.georgiosKachrimanis;

public class Square {
    public static final String WHITE = "| |";
    public static final String BLACK = "|X|";
    public static final String PLAYER_A = "|A|";
    public static final String PLAYER_B = "|B|";


    private int x, y; // 0 is black , 1 is white collor tile
    private int squareValue;


    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Square(int x, int y, int squareValue) {
        this.x = x;
        this.y = y;
        this.squareValue = squareValue;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSquareValue(int value){
        this.squareValue = value;
    }

    public int getSquareValue() {
        return squareValue;
    }

    @Override
    public String toString() {
        return "[ " + (x) + ", " + (y) +"]";
    }
}
