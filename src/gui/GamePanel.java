package gui;

import game.Card;
import game.Difficulty;
import game.GameManager;
import game.GameTimer;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private JLabel titleLabel;
    private JLabel movesLabel;
    private JLabel timerLabel;

    private JPanel cardPanel;

    private GameManager gameManager;
    private GameTimer gameTimer;

    private JButton[] cardButtons;

    private boolean cardsLocked;

    private Timer guiTimer;

    private JFrame frame;

    private Difficulty difficulty;

    public GamePanel(JFrame frame, Difficulty difficulty) {

        this.frame = frame;
        this.difficulty = difficulty;

        gameManager = new GameManager(difficulty);
        gameTimer = new GameTimer();

        cardsLocked = false;

        setLayout(new BorderLayout(10, 10));

        titleLabel = new JLabel(
                "MEMORY MATCH MANIA - " + difficulty,
                SwingConstants.CENTER
        );

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 24)
        );

        movesLabel = new JLabel("Moves: 0");
        timerLabel = new JLabel("Time: 00:00");

        JPanel topPanel =
                new JPanel(new BorderLayout());

        topPanel.add(
                timerLabel,
                BorderLayout.WEST
        );

        topPanel.add(
                titleLabel,
                BorderLayout.CENTER
        );

        topPanel.add(
                movesLabel,
                BorderLayout.EAST
        );

        add(
                topPanel,
                BorderLayout.NORTH
        );

        cardPanel = new JPanel(
                new GridLayout(
                        difficulty.getRows(),
                        difficulty.getColumns(),
                        12,
                        12
                )
        );

        int numberOfCards =
                difficulty.getNumberOfPairs() * 2;

        cardButtons =
                new JButton[numberOfCards];

        for (int i = 0;
             i < cardButtons.length;
             i++) {

            final int index = i;

            cardButtons[i] =
                    new JButton("?");

            cardButtons[i].setFont(
                    new Font(
                            "Arial",
                            Font.BOLD,
                            30
                    )
            );

            cardButtons[i].setPreferredSize(
                    new Dimension(100, 80)
            );

            cardButtons[i].setFocusPainted(false);

            cardButtons[i].addActionListener(
                    e -> handleCardClick(index)
            );

            cardPanel.add(
                    cardButtons[i]
            );
        }

        add(
                cardPanel,
                BorderLayout.CENTER
        );

        startTimer();
    }

    private void startTimer() {

        gameTimer.start();

        guiTimer = new Timer(
                200,
                e -> updateTimerLabel()
        );

        guiTimer.start();
    }

    private void updateTimerLabel() {

        int seconds =
                gameTimer.getSeconds();

        int minutes =
                seconds / 60;

        int remainingSeconds =
                seconds % 60;

        timerLabel.setText(
                String.format(
                        "Time: %02d:%02d",
                        minutes,
                        remainingSeconds
                )
        );
    }

    private void handleCardClick(int index) {

        if (cardsLocked) {
            return;
        }

        Card selectedCard =
                gameManager
                        .getBoard()
                        .getCards()
                        .get(index);

        if (selectedCard.isFaceUp()
                || selectedCard.isMatched()) {

            return;
        }

        gameManager.selectCard(index);

        selectedCard =
                gameManager
                        .getBoard()
                        .getCards()
                        .get(index);

        cardButtons[index].setText(
                selectedCard.getValue()
        );

        movesLabel.setText(
                "Moves: "
                        + gameManager.getMoves()
        );

        if (gameManager.getMoves() > 0) {

            cardsLocked = true;

            Timer timer =
                    new Timer(
                            700,
                            e -> {

                                gameManager
                                        .resetUnmatchedCards();

                                updateCards();

                                cardsLocked = false;

                                checkGameComplete();
                            }
                    );

            timer.setRepeats(false);
            timer.start();
        }
    }

    private void updateCards() {

        for (int i = 0;
             i < cardButtons.length;
             i++) {

            Card card =
                    gameManager
                            .getBoard()
                            .getCards()
                            .get(i);

            if (card.isFaceUp()
                    || card.isMatched()) {

                cardButtons[i].setText(
                        card.getValue()
                );

            } else {

                cardButtons[i].setText("?");

            }
        }
    }

    private void checkGameComplete() {

        if (gameManager.isGameComplete()) {

            gameTimer.stop();

            if (guiTimer != null) {
                guiTimer.stop();
            }

            int finalTime =
                    gameTimer.getSeconds();

            int finalMoves =
                    gameManager.getMoves();

            frame.setContentPane(
                    new ResultPanel(
                            frame,
                            finalTime,
                            finalMoves,
                            difficulty
                    )
            );

            frame.revalidate();
            frame.repaint();
        }
    }
}