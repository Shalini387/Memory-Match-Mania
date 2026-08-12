package app;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    // 12 different cards
    private static final String[] CARDS = {
        "🦋", "🌸", "🐱", "🐶",
        "🍎", "🍓", "⚽", "🏀",
        "🚗", "🚀", "⭐", "🌈"
    };

    private static final ArrayList<String> cardValues = new ArrayList<>();

    private static final JButton[] buttons = new JButton[24];

    private static int firstIndex = -1;
    private static int secondIndex = -1;

    private static boolean checking = false;

    private static int moves = 0;
    private static int matches = 0;

    private static JLabel movesLabel;

    public static void main(String[] args) {

        createCards();

        SwingUtilities.invokeLater(Main::createGame);
    }

    // Create two copies of every card
    private static void createCards() {

        cardValues.clear();

        for (String card : CARDS) {
            cardValues.add(card);
            cardValues.add(card);
        }

        Collections.shuffle(cardValues);
    }

    // Create the game window
    private static void createGame() {

        JFrame frame = new JFrame("Memory Match Mania");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        mainPanel.setBorder(
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        // Title
        JLabel title = new JLabel(
            "MEMORY MATCH MANIA",
            SwingConstants.CENTER
        );

        title.setFont(new Font("Arial", Font.BOLD, 28));

        mainPanel.add(title, BorderLayout.NORTH);

        // Card grid
        JPanel gamePanel = new JPanel(
            new GridLayout(4, 6, 10, 10)
        );

        for (int i = 0; i < 24; i++) {

            JButton button = new JButton("?");

            button.setFont(
                new Font("Segoe UI Emoji", Font.PLAIN, 30)
            );

            button.setFocusPainted(false);

            final int index = i;

            button.addActionListener(
                e -> cardClicked(index)
            );

            buttons[i] = button;

            gamePanel.add(button);
        }

        mainPanel.add(gamePanel, BorderLayout.CENTER);

        // Bottom panel
        JPanel bottomPanel = new JPanel(
            new FlowLayout(
                FlowLayout.CENTER,
                20,
                10
            )
        );

        movesLabel = new JLabel("Moves: 0");

        movesLabel.setFont(
            new Font("Arial", Font.BOLD, 18)
        );

        JButton restartButton = new JButton("Restart");

        restartButton.setFont(
            new Font("Arial", Font.BOLD, 16)
        );

        restartButton.addActionListener(
            e -> restartGame()
        );

        bottomPanel.add(movesLabel);
        bottomPanel.add(restartButton);

        mainPanel.add(
            bottomPanel,
            BorderLayout.SOUTH
        );

        frame.add(mainPanel);

        frame.setVisible(true);
    }

    // When a card is clicked
    private static void cardClicked(int index) {

        if (checking) {
            return;
        }

        if (!buttons[index].isEnabled()) {
            return;
        }

        if (index == firstIndex) {
            return;
        }

        // Show card
        buttons[index].setText(
            cardValues.get(index)
        );

        // First card
        if (firstIndex == -1) {

            firstIndex = index;

            return;
        }

        // Second card
        secondIndex = index;

        moves++;

        movesLabel.setText(
            "Moves: " + moves
        );

        checking = true;

        checkMatch();
    }

    // Check whether the two cards match
    private static void checkMatch() {

        String firstCard =
            cardValues.get(firstIndex);

        String secondCard =
            cardValues.get(secondIndex);

        if (firstCard.equals(secondCard)) {

            // Cards match
            buttons[firstIndex].setEnabled(false);
            buttons[secondIndex].setEnabled(false);

            matches++;

            firstIndex = -1;
            secondIndex = -1;

            checking = false;

            // All pairs found
            if (matches == 12) {

                JOptionPane.showMessageDialog(
                    null,
                    "🎉 Congratulations!\n\n"
                    + "You found all 12 pairs!\n"
                    + "Total moves: " + moves,
                    "Game Completed",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }

        } else {

            // Cards don't match
            javax.swing.Timer timer =
                new javax.swing.Timer(
                    700,
                    e -> hideCards()
                );

            timer.setRepeats(false);

            timer.start();
        }
    }

    // Hide unmatched cards
    private static void hideCards() {

        buttons[firstIndex].setText("?");
        buttons[secondIndex].setText("?");

        firstIndex = -1;
        secondIndex = -1;

        checking = false;
    }

    // Restart the game
    private static void restartGame() {

        createCards();

        firstIndex = -1;
        secondIndex = -1;

        checking = false;

        moves = 0;
        matches = 0;

        movesLabel.setText("Moves: 0");

        for (JButton button : buttons) {

            button.setText("?");

            button.setEnabled(true);
        }
    }
}