package game;

public enum Difficulty {

    EASY(4, 2, 4),
    MEDIUM(8, 4, 4),
    HARD(12, 4, 6);

    private final int numberOfPairs;
    private final int rows;
    private final int columns;

    Difficulty(int numberOfPairs, int rows, int columns) {
        this.numberOfPairs = numberOfPairs;
        this.rows = rows;
        this.columns = columns;
    }

    public int getNumberOfPairs() {
        return numberOfPairs;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}