package main.game;

import main.player.Player;

import java.util.ArrayList;

public class MoveEvent {
    Board board;
    Piece piece;
    Position position1;
    Position position2;
    Player movePlayer;
    Player recievePlayer;
    public final boolean isValid;

    public MoveEvent(Player movePlayer, Player recievePlayer, Board board, Piece piece, Position position) {
        this.board = board;
        this.piece = piece;
        this.position1 = board.getLocation(piece);
        this.position2 = position;
        this.movePlayer = movePlayer;
        this.recievePlayer = recievePlayer;
        this.isValid = validateMove();
        if(isValid){
            if(board.getPiece(position.getX(), position.getY()) == null){
                board.move(position.getX(), position.getY(), piece);
            }else{
                clash(piece, board.getPiece(position.getX(), position.getY()));
            }
        }else{
            System.out.println("Invalid move.");
        }
    }

    private void clash(Piece challenger, Piece challenged){
        if(challenged.isWinCondition()){
            System.out.println(challenger.getLabel() + " wins");
            Position temp = board.getLocation(challenged);
            board.remove(challenged);
            board.move(temp.getX(), temp.getY(), challenger);
        }else if(challenger.isBomb() || challenged.isBomb()){
            System.out.println("Tie");
            board.remove(challenged);
            board.remove(challenger);
        }else if(challenger.getRank() == challenged.getRank()){
            System.out.println("Tie");
            board.remove(challenged);
            board.remove(challenger);
        }else if(challenger.isCanMine() && challenged.isMine()){
            System.out.println(challenger.getLabel() + " wins");
            Position temp = board.getLocation(challenged);
            board.remove(challenged);
            board.move(temp.getX(), temp.getY(), challenger);
        }else if(challenged.isMine()){
            System.out.println(challenged.getLabel() + " wins");
            board.remove(challenger);
        }else if(challenger.getRank() < challenged.getRank()){
            System.out.println(challenger.getLabel() + " wins");
            Position temp = board.getLocation(challenged);
            board.remove(challenged);
            board.move(temp.getX(), temp.getY(), challenger);
        }else if(challenger.getRank() > challenged.getRank()){
            System.out.println(challenged.getLabel() + " wins");
            board.remove(challenger);
        }
    }

    private boolean validateMove(){
        if(!piece.isCanMove()){
            return false;
        }
        if(board.headquarters.contains(position1)){
            return false;
        }
        if(board.getPiece(position2.getX(), position2.getY()) != null) {
            if (board.getPiece(position2.getX(), position2.getY()).getOwner().equals(movePlayer) || board.camps.contains(position2)) {
                return false;
            }
        }
        if(!board.oneStepMoves.get(position1).contains(position2)){
            if(board.rails.contains(position1)){
                if(piece.isCanTurn()){
                    if(!board.getEngMoves(position1).contains(position2)){
                        return false;
                    }
                }else{
                    if(!board.getRailMoves(position1).contains(position2)){
                        return false;
                    }
                }
            }else{
                return false;
            }
        }
        return true;
    }
}