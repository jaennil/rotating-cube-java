import javax.swing.*;
import java.awt.*;

public class Controls extends JPanel {
    public JCheckBox transparentCheckBox;
    public JCheckBox perspectiveCheckBox;
    public JCheckBox rotationCheckBox;
    public Controls() {
        transparentCheckBox = new JCheckBox("transparent");
        add(transparentCheckBox);
        perspectiveCheckBox = new JCheckBox("perspective view");
        add(perspectiveCheckBox);
        rotationCheckBox = new JCheckBox("auto rotation");
        add(rotationCheckBox);

    }
}
