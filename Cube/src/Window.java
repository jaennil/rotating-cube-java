import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Window extends JFrame {

    public Window() {
        setTitle("Rotating cube");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());
        RotatingCubeComponent rotatingCubeComponent = new RotatingCubeComponent(this);
        add(rotatingCubeComponent, BorderLayout.CENTER);
        Controls controls = new Controls();
        controls.transparentCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                rotatingCubeComponent.setTransparent(!rotatingCubeComponent.isTransparent());
                repaint();
            }
        });
        controls.perspectiveCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                rotatingCubeComponent.setPerspective(!rotatingCubeComponent.isPerspective());
                repaint();
            }
        });

        controls.rotationCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                rotatingCubeComponent.setAutoRotation(!rotatingCubeComponent.isAutoRotation());
                if (controls.rotationCheckBox.isSelected()) {
                    rotatingCubeComponent.createRotationTimer();
                    rotatingCubeComponent.timer.start();
                } else {
                    rotatingCubeComponent.timer.stop();
                }
            }
        });
        add(controls, BorderLayout.SOUTH);
        repaint();
    }
}