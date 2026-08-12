package app;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    // 12 different emojis
    static String[] cards = {
        "🦋", "🌸", "🐱", "🐶",
        "🍎", "🍓", "⚽", "🏀",
        "🚗", "🚀", "⭐", "🌈"
    };

    static ArrayList<String> cardValues = new ArrayList<>();

    static JButton[] buttons = new JButton[24];

    static int firstIndex = -1;
    static int secondIndex = -1;

    static boolean checking = false;

    static int moves = 0;
    static int matches = 0;

    public static void main(String[] args) {

        // Create two copies of every emoji
        for (String card : cards) {
            cardValues.add(card);
            cardValues.add(card);
        }

        // Randomly shuffle the cards
        Collections.shuffle(cardValues);

        SwingUtilities.invokeLater(() -> createGame());
    }

    static void createGame() {

        JFrame frame = new JFrame("Memory Match Mania");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Title
        JLabel title = new JLabel(
                "MEMORY MATCH MANIA",
                SwingConstants.CENTER
        );

        title.setFont(new Font("Arial", Font.BOLD, 28));

        mainPanel.add(title, BorderLayout.NORTH);

        // Game board
        JPanel gamePanel = new JPanel(
                new GridLayout(4, 6, 10, 10)
        );

        for (int i = 0; i < 24; i++) {

            JButton button = new JButton("?");

            button.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 32));

            button.setFocusPainted(false);

            final int index = i;

            button.addActionListener(e -> cardClicked(index));

            buttons[i] = button;

            gamePanel.add(button);
        }

        mainPanel.add(gamePanel, BorderLayout.CENTER);

        // Bottom panel
        JPanel bottomPanel = new JPanel(
                new FlowLayout(FlowLayout.CENTER, 20, 10)
        );

        JLabel movesLabel = new JLabel("Moves: 0");

        movesLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JButton restartButton = new JButton("Restart");

        restartButton.setFont(new Font("Arial", Font.BOLD, 16));

        restartButton.addActionListener(e -> {

            cardValues.clear();

            for (String card : cards) {
                cardValues.add(card);
                cardValues.add(card);
            }

            Collections.shuffle(cardValues);

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
        });

        bottomPanel.add(movesLabel);
        bottomPanel.add(restartButton);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);

        frame.setVisible(true);
    }

    static void cardClicked(int index) {

        // Don't allow clicking while checking two cards
        if (checking) {
            return;
        }

        // Don't allow clicking the same card twice
        if (index == firstIndex) {
            return;
        }

        // Show the card
        buttons[index].setText(cardValues.get(index));

        // First card
        if (firstIndex == -1) {

            firstIndex = index;

        } else {

            // Second card
            secondIndex = index;

            moves++;

            checking = true;

            // Check whether cards match
            if (cardValues.get(firstIndex)
                    .equals(cardValues.get(secondIndex))) {

                // Match found
                buttons[firstIndex].setEnabled(false);
                buttons[secondIndex].setEnabled(false);

                matches++;

                firstIndex = -1;
                secondIndex = -1;

                checking = false;

                // Check if game is complete
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

                // No match - hide cards after 800 milliseconds
                 javax.swing.Timer timer = new javax.swing.Timer(700, e -> checkMatch());{

                    buttons[firstIndex].setText("?");
                    buttons[secondIndex].setText("?");

                    firstIndex = -1;
                    secondIndex = -1;

                    checking = false;

                });

                timer.setRepeats(false);

                timer.start();
            }
        }
    }
}