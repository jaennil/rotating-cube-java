public class R3Vector {
    private double x, y, z;

    public R3Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void scale(double value) {
        x *= value;
        y *= value;
        z *= value;
    }

    public void translate(double x, double y, double z) {
        this.x += x;
        this.y += y;
        this.z += z;
    }

    private void rotateZ(double angle) { //угол в градусах
        angle = Math.toRadians(angle);
        double tx = x * Math.cos(angle) - y * Math.sin(angle);
        y = x * Math.sin(angle) + y * Math.cos(angle);
        x = tx;
    }

    private void rotateX(double angle) {
        angle = Math.toRadians(angle);
        double ty = y * Math.cos(angle) - z * Math.sin(angle);
        z = y * Math.sin(angle) + z * Math.cos(angle);
        y = ty;
    }

    private void rotateY(double angle) {
        angle = Math.toRadians(angle);
        double tx = x * Math.cos(angle) - z * Math.sin(angle);
        z = x * Math.sin(angle) + z * Math.cos(angle);
        x = tx;
    }

    public void rotate(double x, double y, double z) {
        rotateX(x);
        rotateY(y);
        rotateZ(z);
    }

    public static R3Vector toR3Vector(R3Vector begin, R3Vector end) {
        return new R3Vector(end.x - begin.x,
                end.y - begin.y,
                end.z - begin.z);
    }

    public static R3Vector vect(R3Vector a, R3Vector b) {
        return new R3Vector(a.y * b.z - a.z * b.y,
                a.z * b.x - a.x * b.z,
                a.x * b.y - a.y * b.x);
    }
}