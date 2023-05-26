import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private final int HEIGHT = 500;
    private final int WIDTH = 600;
    public JPanel panel;


    public Frame() {
        setTitle("Rotating cube");
//        setBackground(Color.ORANGE);
//        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        panel = new JPanel();
//        panel.setBackground(Color.GREEN);
        panel.setLayout(new BorderLayout());
        getContentPane().add(panel);
    }
}
