package main.ui.controllers;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;

public class BoardController {
    public GridPane upperBoard;
    public GridPane lowerBoard;

    Label test = new Label("连长");

    public void initialize(){
        upperBoard = new GridPane();
        lowerBoard = new GridPane();
        lowerBoard.add(test, 0, 0);
        test.setVisible(true);
        lowerBoard.setVisible(true);
        lowerBoard.setGridLinesVisible(true);

    }
}
