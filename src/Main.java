import game.GameManager;

public class Main {

    public static void main(String[] args) {

        GameManager game = new GameManager(4);

        System.out.println("Number of cards: "
                + game.getBoard().getCards().size());

        System.out.println("Moves: " + game.getMoves());

        game.selectCard(0);
        game.selectCard(1);

        System.out.println("Moves after selecting two cards: "
                + game.getMoves());

        game.resetUnmatchedCards();

        System.out.println("Game complete: "
                + game.isGameComplete());
    }
}