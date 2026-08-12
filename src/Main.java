import game.GameBoard;

public class Main {

    public static void main(String[] args) {

        GameBoard board = new GameBoard(4);

        System.out.println("Shuffled Cards:");
        board.displayCards();
    }
}