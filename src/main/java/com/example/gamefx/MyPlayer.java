package com.example.gamefx;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MyPlayer implements Player{
    private Circle ball;
    private Map map;
    private Position position;

    public MyPlayer(Map map) {
        this.map = map;
        position = map.getStartPosition();
        //Creating the ball at the position of num "2"
        ball = new Circle(position.getX() * map.getUnit() + map.getUnit() / 2
                ,position.getY() * map.getUnit() + map.getUnit() / 2,map.getUnit() / 2, Color.RED);
        map.getChildren().add(ball);
    }

    @Override
    //Move our ball to the right
    public void moveRight() {
        //This if statement checks whether our ball at the edge of the map
        if(ball.getCenterX() >= map.getUnit() * (map.getSize() - 1)) {
            //This if statement checks whether cell at the other edge of the map is "blocked"
            if(map.getValueAt((int)(ball.getCenterY() / map.getUnit()), 0) != 1) {
                ball.setCenterX(map.getUnit() / 2);
                position.setX(0);
            }
            else
                System.out.println("Invalid Position");
        }
        else if(ball.getCenterX() <= map.getUnit() * (map.getSize() - 1)) {
            //This if statement checks whether next cell (right in this case) is "blocked"
            if(map.getValueAt((int)(ball.getCenterY() / map.getUnit()), (int)(ball.getCenterX() / map.getUnit() + 1)) != 1) {
                ball.setCenterX(ball.getCenterX() + map.getUnit());
                position.setX(position.getX() + 1);
            }
            else
                System.out.println("Invalid Position");
        }
        else
            System.out.println("Invalid Position");
    }

    @Override
    //Move our ball to the left
    public void moveLeft() {
        if(ball.getCenterX() <= map.getUnit()) {
            if(map.getValueAt((int)(ball.getCenterY() / map.getUnit()), map.getSize() - 1) != 1) {
                ball.setCenterX((map.getUnit() * map.getSize()) - map.getUnit() / 2);
                position.setX(map.getSize() - 1);
            }
            else
                System.out.println("Invalid Position");
        }
        else if(ball.getCenterX() >= map.getUnit()) {
            if(map.getValueAt((int)(ball.getCenterY() / map.getUnit()), (int)(ball.getCenterX() / map.getUnit() - 1)) != 1) {
                ball.setCenterX(ball.getCenterX() - map.getUnit());
                position.setX(position.getX() - 1);
            }
            else
                System.out.println("Invalid Position");
        }
        else
            System.out.println("Invalid Position");
    }

    @Override
    //Move our ball up
    public void moveUp() {
        if(ball.getCenterY() >= map.getUnit()) {
            if (map.getValueAt((int) (ball.getCenterY() / map.getUnit() - 1), (int) (ball.getCenterX() / map.getUnit())) != 1) {
                ball.setCenterY(ball.getCenterY() - map.getUnit());
                position.setY(position.getY() - 1);
            } else
                System.out.println("Invalid Position");
        }
        else if(ball.getCenterY() <= map.getUnit()) {
            if(map.getValueAt(map.getSize() - 1, (int)(ball.getCenterX() / map.getUnit())) != 1) {
                ball.setCenterY((map.getUnit() * map.getSize()) - map.getUnit() / 2);
                position.setY(map.getSize() - 1);
            }
            else
                System.out.println("Invalid Position");
        }
        else
            System.out.println("Invalid Position");
    }

    @Override
    //Move our ball down
    public void moveDown() {
        if(ball.getCenterY() <= map.getUnit() * (map.getSize() - 1)) {
            if (map.getValueAt((int) (ball.getCenterY() / map.getUnit() + 1), (int) (ball.getCenterX() / map.getUnit())) != 1) {
                ball.setCenterY(ball.getCenterY() + map.getUnit());
                position.setY(position.getY() + 1);
            }
            else
                System.out.println("Invalid Position");
        }
        else if(ball.getCenterY() >= map.getUnit() * (map.getSize() - 1)) {
            if (map.getValueAt(0, (int) (ball.getCenterX() / map.getUnit())) != 1) {
                ball.setCenterY(map.getUnit() / 2);
                position.setY(0);
            }
            else
                System.out.println("Invalid Position");
        }
        else
            System.out.println("Invalid Position");
    }

    @Override
    //Return the position of ball
    public Position getPosition() {
        return position;
    }
}