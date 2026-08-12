package gui;

import game.Difficulty;

import javax.swing.*;
import java.awt.*;

public class DifficultyPanel extends JPanel {

    private JFrame frame;

    public DifficultyPanel(JFrame frame) {

        this.frame = frame;

        setLayout(
                new GridLayout(
                        5,
                        1,
                        10,
                        10
                )
        );

        JLabel title =
                new JLabel(
                        "SELECT DIFFICULTY",
                        SwingConstants.CENTER
                );

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        28
                )
        );

        JButton easyButton =
                new JButton("EASY");

        JButton mediumButton =
                new JButton("MEDIUM");

        JButton hardButton =
                new JButton("HARD");

        JButton backButton =
                new JButton("BACK");

        easyButton.addActionListener(
                e -> startGame(Difficulty.EASY)
        );

        mediumButton.addActionListener(
                e -> startGame(Difficulty.MEDIUM)
        );

        hardButton.addActionListener(
                e -> startGame(Difficulty.HARD)
        );

        backButton.addActionListener(
                e -> showHome()
        );

        add(title);
        add(easyButton);
        add(mediumButton);
        add(hardButton);
        add(backButton);
    }

    private void startGame(Difficulty difficulty) {

        frame.setContentPane(
                new GamePanel(
                        frame,
                        difficulty
                )
        );

        frame.revalidate();
        frame.repaint();
    }

    private void showHome() {

        frame.setContentPane(
                new HomePanel(frame)
        );

        frame.revalidate();
        frame.repaint();
    }
}