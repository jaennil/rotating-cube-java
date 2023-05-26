import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RotatingCubeComponent extends JComponent {
    private Cube cube;
    public RotatingCubeComponent() {
        cube = new Cube();
        cube.scale(250);
        setBackground(Color.PINK);
        rotateCube();
    }

    private void rotateCube() {
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cube.rotate(1,1,1);
                repaint();
            }
        };
        Timer timer = new Timer(10 ,taskPerformer);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D)graphics;
        cube.translate(WIDTH /  2, HEIGHT / 2,0);
        cube.draw(graphics2D);
    }
}
