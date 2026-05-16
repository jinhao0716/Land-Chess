package main.ui.controllers;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import main.game.Board;
import main.game.GameInstance;
import main.game.MoveEvent;
import main.game.Piece;
import main.player.Player;

import java.awt.event.MouseListener;
import java.util.HashMap;

public class BoardController {
    @FXML
    public GridPane upperBoard;
    @FXML
    public GridPane lowerBoard;
    @FXML
    public TilePane pieceHolder;

    private final HashMap<Button, Piece> buttonsMap = new HashMap<>();
    private final HashMap<Piece, Button> piecesMap = new HashMap<>();
    Player player1;
    Player player2;
    Piece currentPiece = null;
    Board board;

    public void initialize(){
        GameInstance gameInstance = new GameInstance();
        Player[] players = gameInstance.getPlayers();
        this.player1 = players[0];
        this.player2 = players[1];
        this.board = gameInstance.getBoard();
        addPieceButtons();

        Piece piece1 = new Piece('1', player2);
        Button temp1 = new Button(piece1.getLabel());
        buttonsMap.put(temp1, piece1);
        piecesMap.put(piece1, temp1);
        temp1.getStyleClass().add("piece-button");
        upperBoard.add(temp1, 0, 0);
        board.add(0,0,piece1);

        Piece piece2 = new Piece('1', player1);
        Button temp2 = new Button(piece2.getLabel());
        buttonsMap.put(temp2, piece2);
        piecesMap.put(piece2, temp2);
        temp2.getStyleClass().add("piece-button");
        upperBoard.add(temp2, 0, 1);
        board.add(1,0,piece2);

        for(Button button: buttonsMap.keySet()){
            System.out.println(buttonsMap.get(button).getLabel());
            button.setOnMouseClicked(event -> {
                if(currentPiece != null && currentPiece.equals(buttonsMap.get(button))){
                    piecesMap.get(currentPiece).getStyleClass().remove("selected-button");
                    currentPiece = null;
                }else{
                    if(buttonsMap.get(button).getOwner().equals(player2)){
                        if(currentPiece != null){
                            new MoveEvent(player1, player2, board, currentPiece, board.getLocation(buttonsMap.get(button)));
                        }
                    }else if(currentPiece == null){
                        currentPiece = buttonsMap.get(button);
                        button.getStyleClass().add("selected-button");
                    }else{
                        piecesMap.get(currentPiece).getStyleClass().remove("selected-button");
                        button.getStyleClass().add("selected-button");
                        currentPiece = buttonsMap.get(button);
                    }
                }
            });
        }
    }

    private void addPieceButtons(){

        Piece piece1 = new Piece('1', player1);
        Button temp1 = new Button(piece1.getLabel());
        buttonsMap.put(temp1, piece1);
        piecesMap.put(piece1, temp1);
        temp1.getStyleClass().add("piece-button");
        pieceHolder.getChildren().add(temp1);

        Piece piece2 = new Piece('2', player1);
        Button temp2 = new Button(piece2.getLabel());
        buttonsMap.put(temp2, piece2);
        piecesMap.put(piece2, temp2);
        temp2.getStyleClass().add("piece-button");
        pieceHolder.getChildren().add(temp2);

        for(int i = 0; i < 2; i++){
            Piece piece3 = new Piece('3', player1);
            Button temp3 = new Button(piece3.getLabel());
            buttonsMap.put(temp3, piece3);
            piecesMap.put(piece3, temp3);
            temp3.getStyleClass().add("piece-button");
            pieceHolder.getChildren().add(temp3);
        }

        for(int i = 0; i < 2; i++){
            Piece piece4 = new Piece('4', player1);
            Button temp4 = new Button(piece4.getLabel());
            buttonsMap.put(temp4, piece4);
            piecesMap.put(piece4, temp4);
            temp4.getStyleClass().add("piece-button");
            pieceHolder.getChildren().add(temp4);
        }

        for(int i = 0; i < 2; i++){
            Piece piece5 = new Piece('5', player1);
            Button temp5 = new Button(piece5.getLabel());
            buttonsMap.put(temp5, piece5);
            piecesMap.put(piece5, temp5);
            temp5.getStyleClass().add("piece-button");
            pieceHolder.getChildren().add(temp5);
        }

        for(int i = 0; i < 2; i++){
            Piece piece6 = new Piece('6', player1);
            Button temp6 = new Button(piece6.getLabel());
            buttonsMap.put(temp6, piece6);
            piecesMap.put(piece6, temp6);
            temp6.getStyleClass().add("piece-button");
            pieceHolder.getChildren().add(temp6);
        }

        for(int i = 0; i < 3; i++){
            Piece piece7 = new Piece('7', player1);
            Button temp7 = new Button(piece7.getLabel());
            buttonsMap.put(temp7, piece7);
            piecesMap.put(piece7, temp7);
            temp7.getStyleClass().add("piece-button");
            pieceHolder.getChildren().add(temp7);
        }

        for(int i = 0; i < 3; i++){
            Piece piece8 = new Piece('8', player1);
            Button temp8 = new Button(piece8.getLabel());
            buttonsMap.put(temp8, piece8);
            piecesMap.put(piece8, temp8);
            temp8.getStyleClass().add("piece-button");
            pieceHolder.getChildren().add(temp8);
        }

        for(int i = 0; i < 3; i++){
            Piece piece9 = new Piece('9', player1);
            Button temp9 = new Button(piece9.getLabel());
            buttonsMap.put(temp9, piece9);
            piecesMap.put(piece9, temp9);
            temp9.getStyleClass().add("piece-button");
            pieceHolder.getChildren().add(temp9);
        }

        for(int i = 0; i < 2; i++){
            Piece pieceB = new Piece('B', player1);
            Button tempB = new Button(pieceB.getLabel());
            buttonsMap.put(tempB, pieceB);
            piecesMap.put(pieceB, tempB);
            tempB.getStyleClass().add("piece-button");
            pieceHolder.getChildren().add(tempB);
        }

        Piece pieceF = new Piece('F', player1);
        Button tempF = new Button(pieceF.getLabel());
        buttonsMap.put(tempF, pieceF);
        piecesMap.put(pieceF, tempF);
        tempF.getStyleClass().add("piece-button");
        pieceHolder.getChildren().add(tempF);
    }
}
