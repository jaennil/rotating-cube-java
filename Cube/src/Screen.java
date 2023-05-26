import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Screen extends JFrame {
    private Cube _cube;
    private BufferedImage buffer;

    private static int _WIDTH = 450;
    private static int _HEIGHT = 450;

    public Screen(Cube cube) {
        _cube = cube;
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(_WIDTH, _HEIGHT));
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2dBuffer = buffer.createGraphics();
        g2dBuffer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2dBuffer.setColor(Color.WHITE);
        g2dBuffer.fillRect(0, 0, getWidth(), getHeight());
        g2dBuffer.translate(_WIDTH /  2, _HEIGHT / 2);
        _cube.draw(g2dBuffer);
        g2dBuffer.dispose();
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(buffer, 0, 0, null);
    }
}
