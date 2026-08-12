package gui;

import javax.swing.*;
import java.awt.*;

public class DifficultyPanel extends JPanel {

    public DifficultyPanel() {
        setLayout(new GridLayout(4, 1, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(40, 80, 40, 80));

        JLabel title = new JLabel("SELECT DIFFICULTY", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 28));

        JButton easyButton = new JButton("EASY");
        JButton mediumButton = new JButton("MEDIUM");
        JButton hardButton = new JButton("HARD");

        easyButton.setFont(new Font("Arial", Font.BOLD, 18));
        mediumButton.setFont(new Font("Arial", Font.BOLD, 18));
        hardButton.setFont(new Font("Arial", Font.BOLD, 18));

        add(title);
        add(easyButton);
        add(mediumButton);
        add(hardButton);
    }
}