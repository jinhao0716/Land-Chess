package main.game;

import main.player.Player;

public class GameInstance {
    private final Board board;
    private final Player player1;
    private final Player player2;
    public GameInstance() {
        this.board = new Board();
        this.player1 = new Player();
        this.player2 = new Player();
    }

    public Board getBoard() {
        return board;
    }

    public String printBoard() {
        return board.toString();
    }

    public Player[] getPlayers() {
        Player[] players = new Player[2];
        players[0] = player1;
        players[1] = player2;
        return players;
    }
}
