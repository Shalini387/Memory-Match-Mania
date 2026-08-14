package gui;

import javax.swing.*;
import java.awt.*;

public class PlayerSetupPanel extends JFrame {

    private JTextField nameField;
    private JTextField ageField;

    public PlayerSetupPanel() {

        setTitle("Memory Match Mania");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridBagLayout());

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("MEMORY MATCH MANIA");
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("Enter your details to begin");
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        nameField = new JTextField();
        nameField.setMaximumSize(new Dimension(300, 35));

        ageField = new JTextField();
        ageField.setMaximumSize(new Dimension(300, 35));

        JLabel nameLabel = new JLabel("Player Name");
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel ageLabel = new JLabel("Age");
        ageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton startButton = new JButton("START GAME");
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        formPanel.add(title);
        formPanel.add(Box.createVerticalStrut(10));
        formPanel.add(subtitle);
        formPanel.add(Box.createVerticalStrut(30));

        formPanel.add(nameLabel);
        formPanel.add(Box.createVerticalStrut(5));
        formPanel.add(nameField);

        formPanel.add(Box.createVerticalStrut(15));

        formPanel.add(ageLabel);
        formPanel.add(Box.createVerticalStrut(5));
        formPanel.add(ageField);

        formPanel.add(Box.createVerticalStrut(25));
        formPanel.add(startButton);

        mainPanel.add(formPanel);

        add(mainPanel);

        startButton.addActionListener(e -> startGame());

        setVisible(true);
    }

    private void startGame() {

        String name = nameField.getText().trim();
        String ageText = ageField.getText().trim();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter your name."
            );
            return;
        }

        if (ageText.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter your age."
            );
            return;
        }

        try {

            int age = Integer.parseInt(ageText);

            if (age < 1 || age > 100) {
                JOptionPane.showMessageDialog(
                        this,
                        "Age must be between 1 and 100."
                );
                return;
            }

            JOptionPane.showMessageDialog(
                    this,
                    "Welcome " + name + "!"
            );

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid number for age."
            );
        }
    }
}