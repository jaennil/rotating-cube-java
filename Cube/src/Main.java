public class Main {
    public static void main(String[] args) {
        Cube cube = new Cube();
        cube.scale(200);
        CubeView cubeView = new CubeView(cube);
        CubeController controller = new CubeController(cubeView, cube);
    }
}