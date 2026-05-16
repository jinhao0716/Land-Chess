package main.game;

import java.util.*;

public class Board{
    private final Piece[][] board;
    private final HashMap<Piece, Position> positions = new HashMap<>();

    public final HashSet<Position> camps = new HashSet<>() {
        {
            add(new Position(2, 1));
            add(new Position(2, 3));
            add(new Position(3, 2));
            add(new Position(4, 1));
            add(new Position(4, 3));
            add(new Position(7, 1));
            add(new Position(7, 3));
            add(new Position(8, 2));
            add(new Position(9, 1));
            add(new Position(9, 3));
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
            add(new Position(6, 1));
            add(new Position(6, 2));
            add(new Position(6, 3));
            add(new Position(6, 4));
            add(new Position(7, 0));
            add(new Position(7, 4));
            add(new Position(8, 0));
            add(new Position(8, 4));
            add(new Position(9, 0));
            add(new Position(9, 4));
            add(new Position(10, 0));
            add(new Position(10, 1));
            add(new Position(10, 2));
            add(new Position(10, 3));
            add(new Position(10, 4));
        }
    };

    public final HashSet<Position> headquarters = new HashSet<>() {
        {
            add(new Position(0, 1));
            add(new Position(0, 3));
            add(new Position(11, 1));
            add(new Position(11, 3));
        }
    };

    public final HashMap<Position, HashSet<Position>> oneStepMoves = new HashMap<>();

    public Board(){
        this.board = new Piece[12][5];
        buildOneStepMoves();
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

    public void move(int x, int y, Piece piece){
        Position cur = getLocation(piece);
        board[cur.getX()][cur.getY()] = null;
        board[x][y] = piece;
        positions.put(piece, new Position(x,y));
    }

    public void remove(Piece piece){
        Position cur = getLocation(piece);
        board[cur.getX()][cur.getY()] = null;
        positions.remove(piece);
    }

    public HashSet<Position> getRailMoves(Position position){
        HashSet<Position> set = new HashSet<>();
        int x = position.getX() + 1;
        while(true){
            Position temp = new Position(x, position.getY());
            if(rails.contains(temp) && getPiece(temp.getX(), temp.getY()) != null){
                set.add(temp);
                break;
            }else if(rails.contains(temp)){
                set.add(temp);
                x++;
            }else{
                break;
            }
        }
        x = position.getX() - 1;
        while(true){
            Position temp = new Position(x, position.getY());
            if(rails.contains(temp) && getPiece(temp.getX(), temp.getY()) != null){
                set.add(temp);
                break;
            }else if(rails.contains(temp)){
                set.add(temp);
                x--;
            }else{
                break;
            }
        }
        int y = position.getY() + 1;
        while(true){
            Position temp = new Position(position.getX(), y);
            if(rails.contains(temp) && getPiece(temp.getX(), temp.getY()) != null){
                set.add(temp);
                break;
            }else if(rails.contains(temp)){
                set.add(temp);
                y++;
            }else{
                break;
            }
        }
        y = position.getY() - 1;
        while(true){
            Position temp = new Position(position.getX(), y);
            if(rails.contains(temp) && getPiece(temp.getX(), temp.getY()) != null){
                set.add(temp);
                break;
            }else if(rails.contains(temp)){
                set.add(temp);
                y--;
            }else{
                break;
            }
        }
        return set;
    }

    public HashSet<Position> getEngMoves(Position position) {
        HashSet<Position> engMoves = new HashSet<>();
        HashSet<Position> visited = new HashSet<>();
        Queue<Position> queue = new LinkedList<>();

        visited.add(position);
        queue.add(position);

        while (!queue.isEmpty()) {
            Position current = queue.poll();
            for (Position neighbor : getAdjHelper(current)) {
                if (visited.contains(neighbor)) continue;
                visited.add(neighbor);
                engMoves.add(neighbor);
                if (getPiece(neighbor.getX(), neighbor.getY()) == null) {
                    queue.add(neighbor);
                }
            }
        }
        return engMoves;
    }

    private List<Position> getAdjHelper(Position position){
        List<Position> neighbors = new ArrayList<>();
        int x = position.getX(), y = position.getY();
        if (x - 1 >= 0 && rails.contains(new Position(x - 1, y))){
            if(!(x == 6 && y != 0 && y != 2 && y != 4))
                neighbors.add(new Position(x - 1, y));
        }
        if (x + 1 < 12 && rails.contains(new Position(x + 1, y))){
            if(!(x == 5 && y != 0 && y != 2 && y != 4))
                neighbors.add(new Position(x + 1, y));
        }
        if (y - 1 >= 0 && rails.contains(new Position(x, y - 1)))
            neighbors.add(new Position(x, y - 1));
        if (y + 1 < 5 && rails.contains(new Position(x, y + 1)))
            neighbors.add(new Position(x, y + 1));
        return neighbors;
    }

    private void buildOneStepMoves(){
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 5; j++){
                HashSet<Position> set = new HashSet<>();
                if(headquarters.contains(new Position(i, j))){
                    continue;
                }
                if(i - 1 >= 0){
                    if(i == 6 && j != 0 && j != 2 && j != 4){
                    }else{
                        set.add(new Position(i - 1, j));
                    }
                }
                if(i + 1 < 12){
                    if(i == 5 && j != 0 && j != 2 && j != 4){
                    }else{
                        set.add(new Position(i + 1, j));
                    }
                }
                if(j - 1 >= 0){
                    set.add(new Position(i, j - 1));
                }
                if(j + 1 < 5){
                    set.add(new Position(i, j + 1));
                }
                if(camps.contains(new Position(i, j))){
                    if(i - 1 >= 0 && j - 1 >= 0) set.add(new Position(i - 1, j - 1));
                    if(i + 1 < 12 && j - 1 >= 0) set.add(new Position(i + 1, j - 1));
                    if(i - 1 >= 0 && j + 1 < 5)  set.add(new Position(i - 1, j + 1));
                    if(i + 1 < 12 && j + 1 < 5)  set.add(new Position(i + 1, j + 1));
                }else{
                    if(camps.contains(new Position(i - 1, j - 1))) set.add(new Position(i - 1, j - 1));
                    if(camps.contains(new Position(i + 1, j - 1))) set.add(new Position(i + 1, j - 1));
                    if(camps.contains(new Position(i - 1, j + 1))) set.add(new Position(i - 1, j + 1));
                    if(camps.contains(new Position(i + 1, j + 1))) set.add(new Position(i + 1, j + 1));
                }
                oneStepMoves.put(new Position(i, j), set);
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 5; j++){
                if(board[i][j] == null){
                    sb.append(" _  ");
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
