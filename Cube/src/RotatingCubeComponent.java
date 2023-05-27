import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RotatingCubeComponent extends JPanel {
    private Cube cube;
    private final int WIDTH = 500;
    private final int HEIGHT = 500;
    public boolean transparent = false;
    public boolean perspective = false;
    public boolean autoRotation = false;
    public Timer timer;
    public RotatingCubeComponent(boolean transparent, boolean perspective, boolean autoRotation) {
        this.transparent = transparent;
        this.perspective = perspective;
        this.autoRotation = autoRotation;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        cube = new Cube();
        cube.scale(200);
        createRotationTimer();
        addMouseListener(new MouseStuff(cube, this));
    }

    public void createRotationTimer() {
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cube.rotate(1,1,1);
                repaint();
            }
        };
        timer = new Timer(1 ,taskPerformer);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D)graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.translate(WIDTH/2, HEIGHT/2);
        if (perspective) {
            cube.drawPerspective(graphics2D, transparent);
        } else {
            cube.draw(graphics2D, transparent);
        }

    }
}
