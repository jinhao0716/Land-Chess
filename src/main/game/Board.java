package main.game;

import java.util.ArrayList;

public class Board {
    private Piece[][] board;
    public final ArrayList<int[]> bases = new ArrayList<>(){
        {
            add(new int[]{2,1});
            add(new int[]{2,3});
            add(new int[]{3,2});
            add(new int[]{4,1});
            add(new int[]{4,3});
            add(new int[]{8,1});
            add(new int[]{8,3});
            add(new int[]{9,2});
            add(new int[]{10,1});
            add(new int[]{10,3});
        }
    };

    public final ArrayList<int[]> prohibited = new ArrayList<>(){
        {
            add(new int[]{6,1});
            add(new int[]{6,3});
        }
    };
    public Board(){
        this.board = new Piece[13][5];
    }

    public Piece getPiece(int x, int y){
        if(board[x][y] != null){
            return board[x][y];
        }
        return null;
    }

    public void add(int x, int y, Piece piece){
        board[x][y] = piece;
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


