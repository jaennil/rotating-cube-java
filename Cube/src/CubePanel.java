import javax.swing.*;
import java.awt.*;

public class CubePanel extends JPanel {
    private final int WIDTH = 500;
    private final int HEIGHT = 500;
    private final Cube cube;

    public CubePanel(Cube cube) {
        this.cube = cube;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D)graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.translate(WIDTH/2, HEIGHT/2);

        if (cube.isPerspective())
            cube.drawPerspective(graphics2D, cube.isTransparent());
        else
            cube.draw(graphics2D, cube.isTransparent());
    }
}
