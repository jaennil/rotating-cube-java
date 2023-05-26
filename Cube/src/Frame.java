import javax.swing.JFrame;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class Frame extends JFrame {
    private final int HEIGHT = 500;
    private final int WIDTH = 500;
//    private final Cube cube = new Cube();
//    private BufferedImage bufferedImage;

    public Frame() throws InterruptedException {
        setTitle("Rotating cube");
        setBackground(Color.WHITE);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
//        bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
//        cube = new Cube();
//        cube.scale(250);
    }

//    @Override
//    public void paint(Graphics graphics) {
//        super.paint(graphics);
//        System.out.println("paint");
//        super.paint(graphics);
//        Graphics2D graphics2dBuffer = bufferedImage.createGraphics();
//        Graphics2D graphics2D = (Graphics2D)graphics;
//        graphics2dBuffer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        graphics2dBuffer.setColor(Color.WHITE);
//        graphics2dBuffer.fillRect(0, 0, WIDTH, HEIGHT);
//        graphics2dBuffer.translate(WIDTH /  2, HEIGHT / 2);
//        graphics2D.translate(WIDTH /  2, HEIGHT / 2);
//        cube.draw(graphics2dBuffer);
//        cube.draw(graphics2D);
//        graphics2dBuffer.dispose();
//        Graphics2D graphics2D = (Graphics2D)graphics;
//        graphics2D.drawImage(bufferedImage, 0,0,null);
//    }
}
