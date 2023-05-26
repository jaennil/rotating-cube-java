import javax.swing.*;
import java.awt.*;

public class Controls extends JPanel {
    public JCheckBox transparentCheckBox;
    public Controls() {
//        setSize(10,10);
        setBackground(Color.ORANGE);
        transparentCheckBox = new JCheckBox("transparent");
//        JCheckBox ortogonalCheckBox = new JCheckBox("transparent");
        add(transparentCheckBox);
//        add(ortogonalCheckBox);
    }
}
