import javax.swing.JFrame;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;

public class Frame extends JFrame {
    private final int HEIGHT = 500;
    private final int WIDTH = 500;
    private Cube cube;
    private BufferedImage bufferedImage;

    public Frame() throws InterruptedException {
        setTitle("Rotating cube");
        setBackground(Color.WHITE);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        cube = new Cube();
        cube.scale(250);
        rotateCube();
    }

    private void rotateCube() throws InterruptedException {
        while(true) {
            cube.rotate(1,1,1);
            repaint();
            Thread.sleep(100);
        }
    }

    @Override
    public void paint(Graphics graphics) {
        System.out.println("paint");
        Graphics2D graphics2d = (Graphics2D)graphics;
        super.paint(graphics2d);
        graphics2d.translate(WIDTH /  2, HEIGHT / 2);
        cube.draw(graphics2d);
    }
}
