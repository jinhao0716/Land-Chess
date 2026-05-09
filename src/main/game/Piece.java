package main.game;

import main.player.Player;

public class Piece {
    private final Character rank;
    private boolean canTurn = false;
    private boolean canMine = false;
    private boolean winCondition = false;
    private boolean canMove = true;
    private boolean mine = false;
    private boolean bomb = false;
    private int rankVal;
    private String label = "";
    private Player owner;

    public Piece(Character rank, Player owner) {
        this.owner = owner;
        this.rank = rank;
        switch(rank){
            case '1':
                this.rankVal = 1;
                this.label = "司令";
                break;
            case '2':
                this.rankVal = 2;
                this.label = "军长";
                break;
            case '3':
                this.rankVal = 3;
                this.label = "师长";
                break;
            case '4':
                this.rankVal = 4;
                this.label = "旅长";
                break;
            case '5':
                this.rankVal = 5;
                this.label = "团长";
                break;
            case '6':
                this.rankVal = 6;
                this.label = "营长";
                break;
            case '7':
                this.rankVal = 7;
                this.label = "连长";
                break;
            case '8':
                this.rankVal = 8;
                this.label = "排长";
                break;
            case '9':
                this.rankVal = 9;
                this.canTurn = true;
                this.canMine = true;
                this.label = "工兵";
                break;
            case 'M':
                this.rankVal = -1;
                this.mine = true;
                this.canMove = false;
                this.label = "地雷";
                break;
            case 'B':
                this.rankVal = -2;
                this.bomb = true;
                this.label = "炸弹";
                break;
            case 'F':
                this.rankVal = 999;
                this.winCondition = true;
                this.canMove = false;
                this.label = "军旗";
                break;
            default:
                throw new IllegalArgumentException("Illegal rank");
        }
    }

    public String getLabel(){
        return this.label;
    }

    public int getRank(){
        return this.rankVal;
    }

    public Player getOwner(){
        return this.owner;
    }

    public boolean isCanTurn(){
        return this.canTurn;
    }
    public boolean isCanMine(){
        return this.canMine;
    }
    public boolean isCanMove(){
        return this.canMove;
    }
    public boolean isWinCondition(){
        return this.winCondition;
    }
    public boolean isMine(){
        return this.mine;
    }
    public boolean isBomb(){
        return this.bomb;
    }
}
