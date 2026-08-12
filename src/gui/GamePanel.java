package gui;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private JLabel titleLabel;
    private JLabel movesLabel;
    private JLabel timerLabel;

    public GamePanel() {

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
    }
}