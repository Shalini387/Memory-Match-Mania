package gui;

import javax.swing.*;
import java.awt.*;

public class ResultPanel extends JPanel {

    public ResultPanel() {
        setLayout(new GridLayout(4, 1, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(50, 80, 50, 80));

        JLabel title = new JLabel("GAME COMPLETED!", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 28));

        JLabel scoreLabel = new JLabel("Score: 0", SwingConstants.CENTER);
        JLabel movesLabel = new JLabel("Moves: 0", SwingConstants.CENTER);

        JButton playAgainButton = new JButton("PLAY AGAIN");

        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        movesLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        playAgainButton.setFont(new Font("Arial", Font.BOLD, 18));

        add(title);
        add(scoreLabel);
        add(movesLabel);
        add(playAgainButton);
    }
}