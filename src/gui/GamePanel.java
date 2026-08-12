package gui;

import game.Card;
import game.GameManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private JLabel titleLabel;
    private JLabel movesLabel;
    private JLabel timerLabel;

    private JPanel cardPanel;

    private GameManager gameManager;

    private JButton[] cardButtons;

    private boolean cardsLocked;

    public GamePanel() {

        gameManager = new GameManager(4);
        cardsLocked = false;

        setLayout(new BorderLayout());

        titleLabel = new JLabel("MEMORY MATCH MANIA", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));

        movesLabel = new JLabel("Moves: 0");
        timerLabel = new JLabel("Time: 00:00");

        JPanel topPanel = new JPanel(new BorderLayout());

        topPanel.add(timerLabel, BorderLayout.WEST);
        topPanel.add(titleLabel, BorderLayout.CENTER);
        topPanel.add(movesLabel, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        cardPanel = new JPanel(new GridLayout(2, 4, 10, 10));

        cardButtons = new JButton[8];

        for (int i = 0; i < cardButtons.length; i++) {

            final int index = i;

            cardButtons[i] = new JButton("?");

            cardButtons[i].setFont(
                    new Font("Arial", Font.BOLD, 24)
            );

            cardButtons[i].addActionListener(
                    e -> handleCardClick(index)
            );

            cardPanel.add(cardButtons[i]);
        }

        add(cardPanel, BorderLayout.CENTER);
    }

    private void handleCardClick(int index) {

        if (cardsLocked) {
            return;
        }

        Card selectedCard =
                gameManager.getBoard().getCards().get(index);

        if (selectedCard.isFaceUp() || selectedCard.isMatched()) {
            return;
        }

        boolean result = gameManager.selectCard(index);

        selectedCard =
                gameManager.getBoard().getCards().get(index);

        cardButtons[index].setText(
                selectedCard.getValue()
        );

        movesLabel.setText(
                "Moves: " + gameManager.getMoves()
        );

        if (gameManager.getMoves() > 0) {

            cardsLocked = true;

            Timer timer = new Timer(700, e -> {

                gameManager.resetUnmatchedCards();

                updateCards();

                cardsLocked = false;

            });

            timer.setRepeats(false);
            timer.start();
        }
    }

    private void updateCards() {

        for (int i = 0; i < cardButtons.length; i++) {

            Card card =
                    gameManager.getBoard().getCards().get(i);

            if (card.isFaceUp() || card.isMatched()) {

                cardButtons[i].setText(
                        card.getValue()
                );

            } else {

                cardButtons[i].setText("?");

            }
        }
    }
}