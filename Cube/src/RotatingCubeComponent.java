import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RotatingCubeComponent extends JPanel {
    private Cube cube;
    private Window window;
    private final int WIDTH = 500;
    private final int HEIGHT = 500;
    public boolean transparent = false;
    public boolean perspective = false;
    public boolean autoRotation = false;
    public Timer timer;

    public boolean isTransparent() {
        return transparent;
    }

    public void setTransparent(boolean transparent) {
        this.transparent = transparent;
    }

    public boolean isPerspective() {
        return perspective;
    }

    public void setPerspective(boolean perspective) {
        this.perspective = perspective;
    }

    public boolean isAutoRotation() {
        return autoRotation;
    }

    public void setAutoRotation(boolean autoRotation) {
        this.autoRotation = autoRotation;
    }

    public RotatingCubeComponent(Window window) {
        this.window = window;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        cube = new Cube();
        cube.scale(200);
        createRotationTimer();
        MouseStuff mouseStuff = new MouseStuff(cube, this);
        addMouseListener(mouseStuff);
        addMouseMotionListener(mouseStuff);
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
