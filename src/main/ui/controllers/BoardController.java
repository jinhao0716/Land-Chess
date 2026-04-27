package main.ui.controllers;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import main.game.Piece;

public class BoardController {
    @FXML
    public GridPane upperBoard;
    @FXML
    public GridPane lowerBoard;
    @FXML
    public GridPane pieceHolder;

    public void initialize(){

        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 15; j++){
                Piece piece = new Piece('1');
                Button temp = new Button(piece.getLabel());
                temp.getStyleClass().add("piece-button");
                pieceHolder.add(temp, i, j);
            }
        }
    }
}
