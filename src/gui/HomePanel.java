package gui;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {

    private JFrame frame;

    public HomePanel(JFrame frame) {

        this.frame = frame;

        setLayout(
                new GridLayout(
                        4,
                        1,
                        10,
                        10
                )
        );

        JLabel title =
                new JLabel(
                        "MEMORY MATCH MANIA",
                        SwingConstants.CENTER
                );

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        32
                )
        );

        JButton playButton =
                new JButton("PLAY GAME");

        JButton exitButton =
                new JButton("EXIT");

        playButton.addActionListener(
                e -> showDifficulty()
        );

        exitButton.addActionListener(
                e -> System.exit(0)
        );

        add(title);
        add(playButton);
        add(exitButton);
    }

    private void showDifficulty() {

        frame.setContentPane(
                new DifficultyPanel(frame)
        );

        frame.revalidate();
        frame.repaint();
    }
}