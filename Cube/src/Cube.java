import java.awt.*;

public class Cube {
    private boolean transparent = false;
    private boolean perspective = false;
    private final Facet[] facets;

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
                new R3Vector(0, 0, 1), Color.YELLOW);
        //левая боковая грань в плоскости YZ
        facets[4] = new Facet(new R3Vector(0, 0, 0), new R3Vector(0, 0, 1), new R3Vector(0, 1, 1),
                new R3Vector(0, 1, 0), Color.PINK);
        //правая боковая грань
        facets[5] = new Facet(new R3Vector(1, 1, 0), new R3Vector(1, 1, 1), new R3Vector(1, 0, 1),
                new R3Vector(1, 0, 0), Color.CYAN);
        // make cube inside center
        this.translate(-0.5, -0.5, -0.5);
    }

    public void scale(double k) {
        for (Facet facet : facets) {
            facet.scale(k);
        }
    }

    public void translate(double x, double y, double z) {
        for (Facet facet : facets)
            facet.translate(x, y, z);
    }

    public void rotate(double x, double y, double z){
        for (Facet facet : facets) {
            facet.rotate(x, y, z);
        }
    }

    public void draw(Graphics2D graphics, boolean transparent) {
        for (Facet facet : facets) facet.draw(graphics, transparent);
    }

    public void drawPerspective(Graphics2D graphics, boolean transparent) {
        for (Facet facet : facets) facet.drawPerspective(graphics, 600, transparent);
    }

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

}
