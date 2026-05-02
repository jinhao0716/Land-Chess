package main.game;

import main.player.Player;

public class MoveEvent {
    Board board;
    Piece piece;
    int x;
    int y;
    public MoveEvent(Player movePlayer, Player recievePlayer, Board board, Piece piece, int x, int y) {
        this.board = board;
        this.piece = piece;
        this.x = x;
        this.y = y;
        validateMove();
    }

    private boolean validateMove(){
        int[] moveArray = new int[]{x, y};
        if(board.prohibited.contains(moveArray)){
            return false;
        }else if(board.bases.contains(moveArray)){
            if(board.getPiece(x, y) != null){
                return false;
            }
        }
        if(board.getPiece(x, y) != null) {

        }
        return true;
    }
}
