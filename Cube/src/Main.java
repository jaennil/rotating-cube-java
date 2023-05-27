import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Frame frame = new Frame();
        RotatingCubeComponent rcc = new RotatingCubeComponent(false, false, false);
        frame.panel.add(rcc, BorderLayout.CENTER);
        Controls controls = new Controls();
        frame.panel.add(controls, BorderLayout.SOUTH);
        controls.transparentCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                rcc.transparent = !rcc.transparent;
                rcc.repaint();
            }
        });
        controls.perspectiveCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                rcc.perspective = !rcc.perspective;
                rcc.repaint();
            }
        });
        controls.rotationCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                rcc.autoRotation = !rcc.autoRotation;
                if (controls.rotationCheckBox.isSelected()) {
                    rcc.createRotationTimer();
                    rcc.timer.start();
                } else {
                    rcc.timer.stop();
                }
            }
        });
    }
}