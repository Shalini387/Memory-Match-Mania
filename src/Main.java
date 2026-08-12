import javax.swing.JFrame;
import gui.GamePanel;

public class Main {

    public static void main(String[] args) {

        JFrame frame =
                new JFrame("Memory Match Mania");

        frame.setSize(
                800,
                600
        );

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        frame.setLocationRelativeTo(null);

        frame.setContentPane(
                new GamePanel(frame)
        );

        frame.setVisible(true);
    }
}