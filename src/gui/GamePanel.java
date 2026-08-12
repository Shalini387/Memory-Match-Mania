package gui;

import game.Card;
import game.GameBoard;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private JLabel titleLabel;
    private JLabel movesLabel;
    private JLabel timerLabel;

    private JPanel cardPanel;
    private GameBoard board;

    public GamePanel() {

        board = new GameBoard(4);

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

        for (Card card : board.getCards()) {

            JButton cardButton = new JButton("?");

            cardButton.setFont(new Font("Arial", Font.BOLD, 24));

            cardPanel.add(cardButton);
        }

        add(cardPanel, BorderLayout.CENTER);
    }
}