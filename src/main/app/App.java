package main.app;

import main.game.Board;
import main.game.Piece;
import main.player.Player;

public class App{
    public static void main(String[] args) {
        //GUI.launch(GUI.class, args);
        Board board = new Board();
        Piece piece = new Piece('1', new Player());
        board.add(0,0,piece);
        System.out.println(board);
        System.out.println(board.getPiece(0, 0).getLabel());
    }
}
