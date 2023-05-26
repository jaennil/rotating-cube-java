import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;

public class Facet {
    private R3Vector[] vertex;
    private Color color;

    public Facet(R3Vector v1, R3Vector v2, R3Vector v3, R3Vector v4, Color color) {
        vertex = new R3Vector[4];
        vertex[0] = v1;
        vertex[1] = v2;
        vertex[2] = v3;
        vertex[3] = v4;
        this.color = color;
    }

    public void scale(double value) {
        for (R3Vector vector : vertex)
            vector.scale(value);
    }

    public void translate(double x, double y, double z) {
        for (R3Vector vector : vertex)
            vector.translate(x, y, z);
    }

    public void rotate(double x, double y, double z) {
        for (R3Vector vector : vertex)
            vector.rotate(x, y, z);
    }

    public void draw(Graphics2D graphics, boolean transparent) {
        double averageZ = 0;
        for (int i = 0; i < 4; i++) {
            averageZ+=vertex[i].getZ();
        }
        averageZ/=4;
        if (averageZ <= 0) return;
        Path2D path = new Path2D.Double();
        path.moveTo(vertex[0].getX(), vertex[0].getY());
        path.lineTo(vertex[1].getX(), vertex[1].getY());
        path.lineTo(vertex[2].getX(), vertex[2].getY());
        path.lineTo(vertex[3].getX(), vertex[3].getY());
        path.lineTo(vertex[0].getX(), vertex[0].getY());
        if (transparent == false)
            graphics.fill(path);
        path.closePath();
        graphics.setColor(color);
        graphics.draw(path);
    }
}
