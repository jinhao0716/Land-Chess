package main.ui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;

public class BoardController {
    @FXML
    public GridPane upperBoard;
    @FXML
    public GridPane lowerBoard;

    public void initialize(){

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 6; j++){
                Button test = new Button("连长");
                test.setPrefSize(100, 30);
                lowerBoard.add(test, i, j);
            }
        }
    }
}
