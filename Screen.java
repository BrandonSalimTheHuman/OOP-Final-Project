package OOP;

import javax.swing.*;
import java.awt.*;

public abstract class Screen {
    protected JPanel panel;

    public void setup(){
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(0xf0d9fc));
    }

    public JPanel get_panel() {
        return panel;
    }
}
