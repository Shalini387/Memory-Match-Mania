package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameBoard {

    private ArrayList<Card> cards;

    public GameBoard(int numberOfPairs) {
        cards = new ArrayList<>();

        for (char value = 'A'; value < 'A' + numberOfPairs; value++) {
            cards.add(new Card(String.valueOf(value)));
            cards.add(new Card(String.valueOf(value)));
        }

        Collections.shuffle(cards);
    }

    public List<Card> getCards() {
        return cards;
    }

    public void displayCards() {
        for (Card card : cards) {
            System.out.print(card.getValue() + " ");
        }
        System.out.println();
    }
}