import javax.swing.JFrame;
import java.awt.Color;

public class Frame extends JFrame {
    public static final int HEIGHT = 600;
    public static final int WIDTH = 600;

    public Frame() {
        setTitle("Rotating cube");
        setBackground(Color.ORANGE);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
