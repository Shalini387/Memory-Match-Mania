package gui;

import game.Difficulty;

import javax.swing.*;
import java.awt.*;

public class ResultPanel extends JPanel {

    private JLabel titleLabel;
    private JLabel timeLabel;
    private JLabel movesLabel;

    private JButton playAgainButton;
    private JButton homeButton;

    private JFrame frame;
    private Difficulty difficulty;

    public ResultPanel(
            JFrame frame,
            int seconds,
            int moves,
            Difficulty difficulty) {

        this.frame = frame;
        this.difficulty = difficulty;

        setLayout(
                new BorderLayout(
                        20,
                        20
                )
        );

        titleLabel =
                new JLabel(
                        "YOU WON!",
                        SwingConstants.CENTER
                );

        titleLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        36
                )
        );

        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;

        timeLabel =
                new JLabel(
                        String.format(
                                "Time: %02d:%02d",
                                minutes,
                                remainingSeconds
                        ),
                        SwingConstants.CENTER
                );

        movesLabel =
                new JLabel(
                        "Moves: " + moves,
                        SwingConstants.CENTER
                );

        timeLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        movesLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        JPanel resultInfoPanel =
                new JPanel(
                        new GridLayout(
                                2,
                                1,
                                10,
                                10
                        )
                );

        resultInfoPanel.add(timeLabel);
        resultInfoPanel.add(movesLabel);

        JPanel buttonPanel =
                new JPanel();

        playAgainButton =
                new JButton("PLAY AGAIN");

        homeButton =
                new JButton("HOME");

        playAgainButton.addActionListener(
                e -> playAgain()
        );

        homeButton.addActionListener(
                e -> goHome()
        );

        buttonPanel.add(
                playAgainButton
        );

        buttonPanel.add(
                homeButton
        );

        add(
                titleLabel,
                BorderLayout.NORTH
        );

        add(
                resultInfoPanel,
                BorderLayout.CENTER
        );

        add(
                buttonPanel,
                BorderLayout.SOUTH
        );
    }

    private void playAgain() {

        frame.setContentPane(
                new GamePanel(
                        frame,
                        difficulty
                )
        );

        frame.revalidate();
        frame.repaint();
    }

    private void goHome() {

        frame.setContentPane(
                new HomePanel(frame)
        );

        frame.revalidate();
        frame.repaint();
    }
}