package OOP;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GUI {
    private final CardLayout card_layout;
    private final JPanel card_panel;

    public GUI() throws UnsupportedAudioFileException, IOException {
        // Create new frame
        // Declare attributes
        JFrame frame = new JFrame();

        // Create card layout and card panel
        card_layout = new CardLayout();
        card_panel = new JPanel(card_layout);

        // Create instances of other panels
        TopicScreen topic_screen = new TopicScreen(this);
        TitleScreen title_screen = new TitleScreen(this, topic_screen);

        // :)
        Rickroll rick = new Rickroll();

        // Add other panels to this main frame
        card_panel.add(title_screen.get_panel(), "title_screen");
        card_panel.add(topic_screen.get_panel(), "topic_screen");

        // :)
        card_panel.add(rick.get_panel(), "rickroll");

        // Initialize frame size, then center it on screen
        frame.setSize(700, 900);
        frame.setLocationRelativeTo(null);

        // Set the card panel to be the content pane of the main frame
        frame.setContentPane(card_panel);

        // Start at the title screen
        card_layout.show(card_panel, "title_screen");

        // Make frame visible
        frame.setVisible(true);

        // Automatically terminates the program when the close button is clicked on the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Add questions panel
    public void add_questions(JPanel question_panels){
        card_panel.add(question_panels, "questions");
    }

    // Add results screen
    public void add_result_screen(ResultScreen result_screen){
        card_panel.add(result_screen.get_panel(), "result_screen");
    }

    // Method to switch to the specified screen
    public void switch_to_screen(String screenName) {
        card_layout.show(card_panel, screenName);
    }

    // Driver
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException {
        GUI gui = new GUI();
    }
}
