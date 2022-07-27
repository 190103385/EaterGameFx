package com.example.gamefx;

public class Position {

    private int x;
    private int y;

    //Constructor to get the value of x and y
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Returns the x coordinate
    public int getX() {
        return x;
    }

    //Change the x coordinate
    public void setX(int x) {
        this.x = x;
    }

    //Returns the y coordinate
    public int getY() {
        return y;
    }

    //Change the y coordinate
    public void setY(int y) {
        this.y = y;
    }

    //Check two positions for equality
    public boolean equals(Position pos) {
        return pos.getX() == x && pos.getY() == y;
    }
}
