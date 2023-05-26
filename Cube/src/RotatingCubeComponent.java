import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RotatingCubeComponent extends JPanel {
    private Cube cube;
    public RotatingCubeComponent() {
        setBackground(Color.PINK);
        cube = new Cube();
        cube.scale(200);
        rotateCube();
    }

    private void rotateCube() {
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cube.rotate(1,1,1);
                repaint();
            }
        };
        Timer timer = new Timer(1 ,taskPerformer);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D)graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.translate(Frame.WIDTH/2, Frame.HEIGHT/2);
        cube.draw(graphics2D);
    }
}
