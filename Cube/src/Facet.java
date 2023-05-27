import java.awt.*;
import java.awt.geom.Path2D;

public class Facet {
    private R3Vector[] vertex;
    private Color color;
    private boolean transparent = false;

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
        this.transparent = transparent;
        R3Vector vector = R3Vector.vect(R3Vector.toR3Vector(vertex[0], vertex[1]), R3Vector.toR3Vector(vertex[1],vertex[2]));
        graphics.setColor(color);
        if (vector.getZ() <= 0) return;
        Path2D path = new Path2D.Double();
        path.moveTo(vertex[0].getX(), vertex[0].getY());
        path.lineTo(vertex[1].getX(), vertex[1].getY());
        path.lineTo(vertex[2].getX(), vertex[2].getY());
        path.lineTo(vertex[3].getX(), vertex[3].getY());
        path.lineTo(vertex[0].getX(), vertex[0].getY());
        if (transparent == false)
            graphics.fill(path);
        path.closePath();
        graphics.draw(path);
    }

    public void drawPerspective(Graphics2D g, int c, boolean transparent){
        g.setColor(color);
        double[] newX = new double[5];
        double[] newY = new double[5];
        R3Vector[] newVectors = new R3Vector[5];
        double t;
        c=-c;
        for (int i = 0; i < 4; i++) {
            t = 1 + vertex[i].getZ()/c;
            newX[i] = ((vertex[i].getX()) / t);
            newY[i] = ((vertex[i].getY()) / t);
            newVectors[i] = new R3Vector(newX[i], newY[i], vertex[i].getZ());
        }
        t = 1 + vertex[0].getZ()/c;
        newX[4] = ((vertex[0].getX()) / t);
        newY[4] = ((vertex[0].getY()) / t);

        R3Vector vector = R3Vector.vect(R3Vector.toR3Vector(newVectors[0], newVectors[1]), R3Vector.toR3Vector(newVectors[1], newVectors[2]));
        if (vector.getZ() <= 0) return;
        Path2D p = new Path2D.Double();
        p.moveTo(newX[0], newY[0]);
        for (int i = 1; i < 5; i++) {
            p.lineTo(newX[i], newY[i]);
        }
        if (transparent == false)
            g.fill(p);
        p.closePath();
        g.draw(p);
    }
}
