
package com.georgiosKachrimanis;

public class Player {
    public static final String PLAYER_A = "|A|";
    public static final String PLAYER_B = "|B|";
    private int x;
    private int y;
    private String name;

    public Player(){

    }

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Player(int x, int y, String name){
        this.x= x;
        this.y = y;
        this.name = name;
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

    public void setXY(Square square){
        this.x = square.getX();
        this.y = square.getY();
    }


    @Override
    public String toString() {
        return ( " Square(" + (x+1) + ", " + (y+1) + ").");
    }

}
