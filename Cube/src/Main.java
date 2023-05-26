import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Frame frame = new Frame();
        RotatingCubeComponent rcc = new RotatingCubeComponent(false);
        frame.panel.add(rcc, BorderLayout.CENTER);
        Controls controls = new Controls();
        frame.panel.add(controls, BorderLayout.SOUTH);
        controls.transparentCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                rcc.transparent = !rcc.transparent;
            }
        });
    }
}