import javax.swing.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Frame frame = new Frame();
        RotatingCubeComponent rcc = new RotatingCubeComponent();
        frame.getContentPane().add(rcc);
    }
}