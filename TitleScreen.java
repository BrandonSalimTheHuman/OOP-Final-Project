package OOP;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleScreen extends Screen implements ActionListener {
    // Declare attributes
    private final GUI gui;
    private final TopicScreen topic_screen;
    public TitleScreen(GUI gui, TopicScreen topic_screen){
        this.gui = gui;
        this.topic_screen = topic_screen;

        // Initialize panel and layout
        setup();

        // Set center alignment
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create JLabel and its text
        JLabel title_text = new JLabel("Music Quiz");

        // Create font and apply
        Font font = new Font("Georgia", Font.BOLD, 105);
        title_text.setFont(font);

        // Center align the label horizontally
        title_text.setAlignmentX(Component.CENTER_ALIGNMENT);
        title_text.setHorizontalAlignment(JLabel.CENTER);

        // Create button and its text
        JButton start_button = new JButton("Start game");

        // Create font and apply
        Font font2 = new Font("Georgia", Font.BOLD, 60);
        start_button.setFont(font2);

        // Create second button to reset
        JButton reset_button = new JButton("Reset high scores");

        // Create font and apply
        Font font3 = new Font("Georgia", Font.BOLD, 30);
        reset_button.setFont(font3);

        // Set action command to tell apart from starting game button
        reset_button.setActionCommand("reset");

        // Center align buttons
        start_button.setAlignmentX(Component.CENTER_ALIGNMENT);
        reset_button.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Attach action listener to button
        start_button.addActionListener(this);
        reset_button.addActionListener(this);

        // Add text and button to panel
        panel.add(Box.createVerticalStrut(200));
        panel.add(title_text);
        panel.add(Box.createVerticalStrut(150));
        panel.add(start_button);
        panel.add(Box.createVerticalStrut(100));
        panel.add(reset_button);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("reset")){
            // reset high scores
            topic_screen.reset_scores();
        }
        else {
            // Switch to topic screen
            gui.switch_to_screen("topic_screen");
        }
    }
}
