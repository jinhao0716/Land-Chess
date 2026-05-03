package main.game;

import main.player.Player;

public class MoveEvent {
    Board board;
    Piece piece;
    Position position;
    Player movePlayer;
    Player recievePlayer;
    public MoveEvent(Player movePlayer, Player recievePlayer, Board board, Piece piece, Position position) {
        this.board = board;
        this.piece = piece;
        this.position = position;
        this.movePlayer = movePlayer;
        this.recievePlayer = recievePlayer;
        validateMove();
    }

    private boolean validateMove(){
        return true;
    }
}
