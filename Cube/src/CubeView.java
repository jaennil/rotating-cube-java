import javax.swing.*;
import java.awt.*;

public class CubeView extends JFrame {

    JCheckBox transparentCheckBox;
    JCheckBox perspectiveCheckBox;
    JCheckBox rotationCheckBox;
    CubePanel cubePanel;
    public CubeView(Cube cube) {
        setTitle("Rotating cube");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());

        cubePanel = new CubePanel(cube);
        add(cubePanel, BorderLayout.CENTER);

        JPanel checkBoxesPanel = new JPanel();
        transparentCheckBox = new JCheckBox("transparent");
        perspectiveCheckBox = new JCheckBox("perspective view");
        rotationCheckBox = new JCheckBox("auto rotation");
        checkBoxesPanel.add(transparentCheckBox);
        checkBoxesPanel.add(perspectiveCheckBox);
        checkBoxesPanel.add(rotationCheckBox);
        this.add(checkBoxesPanel, BorderLayout.SOUTH);

        repaint();
    }
}