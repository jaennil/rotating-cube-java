import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseStuff implements MouseListener, MouseMotionListener {
    public int px, py, rx, ry;
    private Cube cube;
    private RotatingCubeComponent rcc;
    private int startx;
    private int starty;
    public MouseStuff(Cube cube, RotatingCubeComponent rcc) {
        this.cube = cube;
        this.rcc = rcc;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startx = e.getX();
        starty = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        double dx = startx-x;
        double dy = starty-y;
        cube.rotate(dy, dx, 0);
        rcc.repaint();
        startx = x;
        starty = y;
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}