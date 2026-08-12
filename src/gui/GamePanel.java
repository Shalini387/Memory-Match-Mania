package gui;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private int moves = 0;
    private int score = 0;

    public GamePanel() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JLabel title = new JLabel("MEMORY MATCH GAME", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 26));

        JPanel cardPanel = new JPanel(new GridLayout(4, 4, 10, 10));
        cardPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        for (int i = 0; i < 16; i++) {
            JButton card = new JButton("?");
            card.setFont(new Font("Arial", Font.BOLD, 24));
            cardPanel.add(card);
        }

        JLabel status = new JLabel(
                "Moves: " + moves + "    Score: " + score,
                SwingConstants.CENTER
        );
        status.setFont(new Font("Arial", Font.BOLD, 18));

        add(title, BorderLayout.NORTH);
        add(cardPanel, BorderLayout.CENTER);
        add(status, BorderLayout.SOUTH);
    }
}