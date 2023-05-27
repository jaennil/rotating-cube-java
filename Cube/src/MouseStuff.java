import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseStuff implements MouseListener {
    public int px, py, rx, ry;
    private Cube cube;
    private RotatingCubeComponent rcc;
    public MouseStuff(Cube cube, RotatingCubeComponent rcc) {
        this.cube = cube;
        this.rcc = rcc;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (rcc.autoRotation) return;
        px = e.getX();
        py = e.getY();
        System.out.println("pressed " + px + " " + py);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (rcc.autoRotation) return;
        rx = e.getX();
        ry = e.getY();
        System.out.println("released " + rx + " " + ry);
        double dx = px-rx;
        double dy = py-ry;
        cube.rotate(dy/10, dx/10, 0);
        rcc.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}