package com.example.gamefx;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map extends Pane {

    private int UNIT = 50;
    private int size;
    private int[][] map;
    private Position start;
    private Label points;

    public Map(String path) throws FileNotFoundException {

        //Reading the txt file by File and Scanner class
        File  file = new File(path);

        Scanner fin = new Scanner(file);

        //First int is the size of the map
        size = fin.nextInt();

        map = new int[size][size];

        //Filling the 2d array
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(fin.next());
            }
        }

        //Loop through the 2d array
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(map[i][j] == 0) {
                    //0 is the "open" (white)square
                    Rectangle r = new Rectangle(j*UNIT, i*UNIT, UNIT,UNIT);
                    r.setFill(Color.TRANSPARENT);
                    r.setStroke(Color.BLACK);
                    getChildren().add(r);
                }
                else if(map[i][j] == 1) {
                    //1 is the "blocked" (black) square
                    Rectangle r = new Rectangle(j*UNIT, i*UNIT, UNIT,UNIT);
                    r.setFill(Color.BLACK);
                    getChildren().add(r);
                }
                else if(map[i][j] == 2) {
                    //2 is the position of ball
                    start = new Position(j, i);

                    Rectangle r = new Rectangle(j*UNIT, i*UNIT, UNIT,UNIT);
                    r.setFill(Color.TRANSPARENT);
                    r.setStroke(Color.BLACK);
                    getChildren().add(r);
                }
            }
        }

        //Label to display the point on screen
//        points = new Label("Points\n" + "   0");
//        points.setTranslateX((size + 0.5) * UNIT);
//        points.setFont(new Font("Arial", 20));
//        points.setTextFill(Color.MIDNIGHTBLUE);
//
//        getChildren().add(points);
    }


    //Change the value of point
    public void putScore(int score) {
        points.setText("Points\n" + "   " + score);
    }

    //Return the size of map
    public int getSize() {
        return size;
    }

    //Return the size of each cell
    public int getUnit() {
        return UNIT;
    }

    //Returns the value at specific place
    public int getValueAt(int row, int column) {
        return map[row][column];
    }

    //Starting position
    public Position getStartPosition() {
        return start;
    }
}