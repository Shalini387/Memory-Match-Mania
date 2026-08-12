package model;

public class GameResult {
    private int id;
    private String username;
    private int score;
    private int moves;
    private int timeTaken;

    public GameResult(int id, String username, int score, int moves, int timeTaken) {
        this.id = id;
        this.username = username;
        this.score = score;
        this.moves = moves;
        this.timeTaken = timeTaken;
    }

    public GameResult(String username, int score, int moves, int timeTaken) {
        this.username = username;
        this.score = score;
        this.moves = moves;
        this.timeTaken = timeTaken;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public int getScore() {
        return score;
    }

    public int getMoves() {
        return moves;
    }

    public int getTimeTaken() {
        return timeTaken;
    }
}