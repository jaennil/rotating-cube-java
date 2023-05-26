import java.awt.*;

public class Cube {
    private Facet[] facets;

    public Cube() {
        facets = new Facet[6];
        //дальняя грань в плоскости xy
        facets[0] = new Facet(new R3Vector(0, 0, 0), new R3Vector(0, 1, 0), new R3Vector(1, 1, 0),
                new R3Vector(1, 0, 0), Color.RED);
        //передняя грань
        facets[1] = new Facet(new R3Vector(0, 1, 1), new R3Vector(0, 0, 1), new R3Vector(1, 0, 1),
                new R3Vector(1, 1, 1), Color.GREEN);
        //верхняя грань
        facets[2] = new Facet(new R3Vector(0, 1, 0), new R3Vector(0, 1, 1), new R3Vector(1, 1, 1),
                new R3Vector(1, 1, 0), Color.BLUE);
        //нижняя грань в плоскости XZ
        facets[3] = new Facet(new R3Vector(0, 0, 0), new R3Vector(1, 0, 0), new R3Vector(1, 0, 1),
                new R3Vector(0, 0, 1), Color.BLUE);
        //левая боковая грань в плоскости YZ
        facets[4] = new Facet(new R3Vector(0, 0, 0), new R3Vector(0, 0, 1), new R3Vector(0, 1, 1),
                new R3Vector(0, 1, 0), Color.MAGENTA);
        //правая боковая грань
        facets[5] = new Facet(new R3Vector(1, 1, 0), new R3Vector(1, 1, 1), new R3Vector(1, 0, 1),
                new R3Vector(1, 0, 0), Color.ORANGE);
        // make cube inside center
        this.translate(-0.5, -0.5, -0.5);
    }

    public void scale(double k) {
        for (Facet facet : facets)
            facet.scale(k);
    }

    public void translate(double x, double y, double z) {
        for (Facet facet : facets)
            facet.translate(x, y, z);
    }

    public void rotate(double x, double y, double z){
        for (Facet facet : facets)
            facet.rotate(x, y, z);
    }

    public void draw(Graphics2D graphics) {
        for (Facet facet : facets) facet.draw(graphics);
    }

}
