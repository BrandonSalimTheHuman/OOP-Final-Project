package OOP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Rickroll extends Screen implements ActionListener {

    private final JLabel label;

    public Rickroll(){
        // Initialize panel and layout
        setup();

        // Initialize video panel and its size and its bg color
        JPanel panel_for_label = new JPanel();
        panel_for_label.setLayout(new GridBagLayout());
        panel_for_label.setPreferredSize(new Dimension(700, 550));
        panel_for_label.setBackground(new Color(0xf0d9fc));

        // Initialize label
        label = new JLabel("<html><div style = 'text-align: center'>The question will only show<br>after you play the audio.<br>Listen carefully.</div></html>");
        Font label_font = new Font("Segoe UI Black", Font.BOLD, 40);
        label.setFont(label_font);

        // Add label to label panel
        panel_for_label.add(label);

        // Initialize button panel and its size and its bg color
        JPanel panel_for_button = new JPanel();
        panel_for_button.setLayout(new GridBagLayout());
        panel_for_button.setPreferredSize(new Dimension(700, 350));
        panel_for_button.setBackground(new Color(0xf0d9fc));

        // Initialize button and its font
        JButton start_button = new JButton("Click to play");
        Font button_font = new Font("Vivaldi", Font.BOLD, 50);
        start_button.setFont(button_font);

        // Add action listener to button
        start_button.addActionListener(this);

        // Add button to button panel
        panel_for_button.add(start_button);

        // Add both panels to main panel
        panel.add(panel_for_label);
        panel.add(panel_for_button);
    }

    // When button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        if (Desktop.isDesktopSupported()) {
            try {
                // Plays the Never Gonna Give You Up video on the desktop using media player
                File videoFile = new File("C:\\Users\\Brandon Salim\\IdeaProjects\\Data_structures\\src\\OOP\\-.mp4");
                Desktop.getDesktop().open(videoFile);

                // Change text on the panel
                label.setText("JK get rickrolled");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            // If Desktop isn't supported
            JOptionPane.showMessageDialog(panel, "Opening the video file is not supported on this platform.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
