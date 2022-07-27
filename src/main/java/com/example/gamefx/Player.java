package com.example.gamefx;

//Interface which was implemented by MyPlayer class
public interface Player {
    //Methods which was implemented by MyPlayer class
    void moveRight();
    void moveLeft();
    void moveUp();
    void moveDown();

    Position getPosition();
}
