import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CubeController {
    private final CubeView view;
    private final Cube cube;
    private Timer rotationTimer;
    public CubeController(CubeView view, Cube model) {
        this.view = view;
        this.cube = model;
        MouseController mouseController = new MouseController(model, view);
        view.addMouseListener(mouseController);
        view.addMouseMotionListener(mouseController);
        view.transparentCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                cube.setTransparent(!cube.isTransparent());
                view.repaint();
            }
        });
        view.perspectiveCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                cube.setPerspective(!cube.isPerspective());
                view.repaint();
            }
        });

        view.rotationCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (view.rotationCheckBox.isSelected()) {
                    createRotationTimer();
                    rotationTimer.start();
                } else {
                    rotationTimer.stop();
                }
            }
        });
    }

    public void createRotationTimer() {
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cube.rotate(1,1,1);
                view.repaint();
            }
        };
        rotationTimer = new Timer(1 ,taskPerformer);
    }
}
