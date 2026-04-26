package main.game;

public class Piece {
    private final Character rank;
    private boolean canTurn = false;
    private boolean canMine = false;
    private boolean winCondition = false;
    private boolean canMove = true;
    private boolean mine = false;
    private boolean bomb = false;
    private int rankVal;

    public Piece(Character rank){
        this.rank = rank;
        switch(rank){
            case '1':
                this.rankVal = 1;
                break;
            case '2':
                this.rankVal = 2;
                break;
            case '3':
                this.rankVal = 3;
                break;
            case '4':
                this.rankVal = 4;
                break;
            case '5':
                this.rankVal = 5;
                break;
            case '6':
                this.rankVal = 6;
                break;
            case '7':
                this.rankVal = 7;
                break;
            case '8':
                this.rankVal = 8;
                break;
            case '9':
                this.rankVal = 9;
                this.canTurn = true;
                this.canMine = true;
                break;
            case 'M':
                this.rankVal = -1;
                this.mine = true;
                this.canMove = false;
                break;
            case 'B':
                this.rankVal = -1;
                this.bomb = true;
                break;
            case 'F':
                this.rankVal = 999;
                this.winCondition = true;
                this.canMove = false;
                break;
        }
    }
}
