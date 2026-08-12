package gui;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {

    public HomePanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(245, 247, 250));

        JLabel title = new JLabel("MEMORY MATCH MANIA", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 32));

        JLabel subtitle = new JLabel(
                "Test your memory and match all the cards!",
                SwingConstants.CENTER
        );
        subtitle.setFont(new Font("Arial", Font.PLAIN, 18));

        JButton startButton = new JButton("START GAME");
        startButton.setFont(new Font("Arial", Font.BOLD, 18));

        JPanel centerPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        centerPanel.setOpaque(false);
        centerPanel.add(title);
        centerPanel.add(subtitle);
        centerPanel.add(startButton);

        add(centerPanel, BorderLayout.CENTER);
    }
}