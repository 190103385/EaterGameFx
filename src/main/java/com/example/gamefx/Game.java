package com.example.gamefx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class Game extends Application {

    private Player myPlayer;
    private Food food;
    private Map myMap;
    private boolean isChanged;
    private int score = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        myMap = new Map("src/main/java/com/example/gamefx/map0.txt");
        myPlayer = new MyPlayer(myMap);
        food = new Food(myMap, myPlayer);

        //Event handlers
        myMap.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.LEFT){
                myPlayer.moveLeft();
                showScore();
            }
            else if(e.getCode() == KeyCode.RIGHT) {
                myPlayer.moveRight();
                showScore();
            }
            else if(e.getCode() == KeyCode.UP) {
                myPlayer.moveUp();
                showScore();
            }
            else if(e.getCode() == KeyCode.DOWN) {
                myPlayer.moveDown();
                showScore();
            }
        });
//
//        BotPlayer botPlayer = new MyBotPlayer(myMap);
//        food = new Food(myMap, botPlayer);
//        botPlayer.feed(food);
//
//        myMap.setOnKeyPressed(e -> {
//            if(e.getCode() == KeyCode.E) {
//                botPlayer.eat();
//            }
//            else if(e.getCode() == KeyCode.F) {
//                botPlayer.find();
//            }
//        });

        Scene scene = new Scene(myMap, myMap.getUnit() * myMap.getSize() , myMap.getUnit() * myMap.getSize());

        primaryStage.setScene(scene);

        //Changing the icon
        primaryStage.getIcons().add(new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/0/06/Pac_Man.svg/1200px-Pac_Man.svg.png"));

        //Changing the title
        primaryStage.setTitle("Eater");
        
        primaryStage.show();
        scene.getRoot().requestFocus();
    }

    //Change the value of points on scene
    private void showScore() {
        Thread thread = new Thread(() -> {
            if(myPlayer.getPosition().equals(food.getPosition())) {
                isChanged = !isChanged;
            } else isChanged = false;
        });
        thread.start();
        if (isChanged) myMap.putScore(food.getPoints());
    }
}