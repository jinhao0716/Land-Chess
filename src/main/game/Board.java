package main.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Board {
    private Piece[][] board;
    private HashMap<Piece, Position> positions = new HashMap<>();

    public final HashSet<Position> camps = new HashSet<>() {
        {
            add(new Position(2, 1));
            add(new Position(2, 3));
            add(new Position(3, 2));
            add(new Position(4, 1));
            add(new Position(4, 3));
            add(new Position(8, 1));
            add(new Position(8, 3));
            add(new Position(9, 2));
            add(new Position(10, 1));
            add(new Position(10, 3));
        }
    };

    public final HashSet<Position> mountains = new HashSet<>() {
        {
            add(new Position(6, 1));
            add(new Position(6, 3));
        }
    };

    public final HashSet<Position> rails = new HashSet<>() {
        {
            add(new Position(1, 0));
            add(new Position(1, 1));
            add(new Position(1, 2));
            add(new Position(1, 3));
            add(new Position(1, 4));
            add(new Position(2, 0));
            add(new Position(2, 4));
            add(new Position(3, 0));
            add(new Position(3, 4));
            add(new Position(4, 0));
            add(new Position(4, 4));
            add(new Position(5, 0));
            add(new Position(5, 1));
            add(new Position(5, 2));
            add(new Position(5, 3));
            add(new Position(5, 4));
            add(new Position(6, 0));
            add(new Position(6, 2));
            add(new Position(6, 4));
            add(new Position(7, 0));
            add(new Position(7, 1));
            add(new Position(7, 2));
            add(new Position(7, 3));
            add(new Position(7, 4));
            add(new Position(8, 0));
            add(new Position(8, 4));
            add(new Position(9, 0));
            add(new Position(9, 4));
            add(new Position(10, 0));
            add(new Position(10, 4));
            add(new Position(11, 0));
            add(new Position(11, 1));
            add(new Position(11, 2));
            add(new Position(11, 3));
            add(new Position(11, 4));
        }
    };

    private HashMap<Position, HashSet<Position>> oneStepMoves = new HashMap<>(){
        {
            for(int i = 0; i < 13; i++){
                for(int j = 0; j < 5; j++){
                    HashSet<Position> set = new HashSet<>();
                    if(i - 1 >= 0 && !mountains.contains(new Position(i - 1, j))){
                        set.add(new Position(i - 1, j));
                    }
                    if(i + 1 < 13 && !mountains.contains(new Position(i + 1, j))){
                        set.add(new Position(i + 1, j));
                    }
                    if(j - 1 >= 0 && !mountains.contains(new Position(i, j - 1))){
                        set.add(new Position(i, j - 1));
                    }
                    if(j + 1 < 5 && !mountains.contains(new Position(i, j + 1))){
                        set.add(new Position(i, j + 1));
                    }
                    if(camps.contains(new Position(i, j))){
                        set.add(new Position(i - 1, j - 1));
                        set.add(new Position(i + 1, j - 1));
                        set.add(new Position(i - 1, j + 1));
                        set.add(new Position(i + 1, j + 1));
                    }else{
                        if(camps.contains(new Position(i - 1, j - 1))){
                            set.add(new Position(i - 1, j - 1));
                        }
                        if(camps.contains(new Position(i + 1, j - 1))){
                            set.add(new Position(i + 1, j - 1));
                        }
                        if(camps.contains(new Position(i - 1, j + 1))){
                            set.add(new Position(i - 1, j + 1));
                        }
                        if(camps.contains(new Position(i + 1, j + 1))){
                            set.add(new Position(i + 1, j + 1));
                        }
                    }
                    oneStepMoves.put(new Position(i, j), set);
                }
            }
        }
    };

    private HashMap<Position, HashSet<Position>> railMoves = new HashMap<>(){
        {
            for (Position position1 : rails){
                HashSet<Position> set = new HashSet<>();
                int x = position1.getX() + 1;
                while(true){
                    Position temp = new Position(x,position1.getY());
                    if(rails.contains(temp)){
                        set.add(temp);
                        x++;
                    }else{
                        break;
                    }
                }
                x = position1.getX() - 1;
                while(true){
                    Position temp = new Position(x,position1.getY());
                    if(rails.contains(temp)){
                        set.add(temp);
                        x--;
                    }else{
                        break;
                    }
                }
                int y = position1.getY() + 1;
                while(true){
                    Position temp = new Position(position1.getX(),y);
                    if(rails.contains(temp)){
                        set.add(temp);
                        y++;
                    }else{
                        break;
                    }
                }
                y = position1.getY() - 1;
                while(true){
                    Position temp = new Position(position1.getX(),y);
                    if(rails.contains(temp)){
                        set.add(temp);
                        y--;
                    }else{
                        break;
                    }
                }
                railMoves.put(position1, set);
            }
        }
    };


    public Board(){
        this.board = new Piece[13][5];
    }

    public Piece getPiece(int x, int y){
        return board[x][y];
    }

    public Position getLocation(Piece piece){
        return positions.get(piece);
    }

    public void add(int x, int y, Piece piece){
        board[x][y] = piece;
        positions.put(piece, new Position(x,y));
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 13; i++){
            for(int j = 0; j < 5; j++){
                if(board[i][j] == null){
                    sb.append("_ ");
                }else{
                    sb.append(board[i][j].getLabel());
                    sb.append(" ");
                }
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
        }
        return sb.toString();
    }
}
