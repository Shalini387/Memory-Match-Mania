package game;

public class GameManager {

    private GameBoard board;
    private Card firstCard;
    private Card secondCard;
    private int moves;
    private Difficulty difficulty;

    public GameManager(Difficulty difficulty) {

        this.difficulty = difficulty;

        board = new GameBoard(
                difficulty.getNumberOfPairs()
        );

        moves = 0;
    }

    public boolean selectCard(int index) {

        if (index < 0 ||
                index >= board.getCards().size()) {

            return false;
        }

        Card selectedCard =
                board.getCards().get(index);

        if (selectedCard.isMatched()
                || selectedCard.isFaceUp()) {

            return false;
        }

        selectedCard.setFaceUp(true);

        if (firstCard == null) {

            firstCard = selectedCard;

            return true;
        }

        secondCard = selectedCard;

        moves++;

        return firstCard.getValue()
                .equals(secondCard.getValue());
    }

    public void resetUnmatchedCards() {

        if (firstCard != null
                && secondCard != null) {

            if (!firstCard.getValue()
                    .equals(secondCard.getValue())) {

                firstCard.setFaceUp(false);
                secondCard.setFaceUp(false);

            } else {

                firstCard.setMatched(true);
                secondCard.setMatched(true);
            }

            firstCard = null;
            secondCard = null;
        }
    }

    public int getMoves() {
        return moves;
    }

    public boolean isGameComplete() {

        for (Card card : board.getCards()) {

            if (!card.isMatched()) {
                return false;
            }
        }

        return true;
    }

    public GameBoard getBoard() {
        return board;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }
}