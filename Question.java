package OOP;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.io.*;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.awt.*;
import java.util.Timer;
import javax.swing.*;

public class Question implements ActionListener {
    // Declare and initialize attributes
    private String text;
    private List<String> choices;
    private List<JButton> choice_buttons;
    private JPanel question_part = new JPanel();
    private final JPanel choices_part = new JPanel();
    private final JPanel choices_part_smaller = new JPanel();
    private String answer;
    private AudioInputStream audio = null;
    private Clip clip = null;
    private JPanel panel;
    private final Font font_question = new Font("Georgia", Font.BOLD, 30);
    private final Font font_choice_4 = new Font("Gloucester MT Extra Condensed", Font.PLAIN, 35);
    private final Font font_choice_2 = new Font("Gloucester MT Extra Condensed", Font.PLAIN, 70);
    private Boolean is_image;
    private Question next = null;
    private Topic topic;
    private GUI gui;

    // Constructor for default MCQ question
    public Question(String text, List<String> choices, String answer, Boolean is_image){
        // Setup that's shared between all constructors
        starting_setup(text, choices, answer, is_image);

        // Create the top part of the panel, the question panel
        create_question_part();

        // Create the bottom part of the panel, the choices panel
        create_choices_part(this.is_image);

        // Add them both to the main panel
        this.panel.add(question_part);
        this.panel.add(choices_part);
    }

    // Constructor for image questions
    public Question(String text, List<String> choices, String answer, String path, Dimension image_size, Boolean is_image) {
        // Setup that's shared between all constructors
        starting_setup(text, choices, answer, is_image);

        // Create question part, then set its size to fit this question type
        create_question_part();
        question_part.setPreferredSize(new Dimension(350, 200));

        // Create choices panel
        create_choices_part(this.is_image);

        // Load image and turn it into JLabel
        Image image1 = load_image(path);
        Image image = image1.getScaledInstance(image_size.width, image_size.height, Image.SCALE_DEFAULT);
        JLabel image_icon = new JLabel(new ImageIcon(image));

        // Initialize a panel for the image, set the image size and bg color, then add it to the panel
        JPanel image_part = new JPanel();
        image_part.setPreferredSize(new Dimension(500, 350));
        image_part.setBackground(new Color(0xf0d9fc));
        image_part.add(image_icon);


        // Add everything to the main panel
        this.panel.add(question_part);
        this.panel.add(image_part);
        this.panel.add(choices_part);
    }

    // Constructor for audio questions
    public Question(String text, List<String> choices, String answer, String path, Boolean is_image) throws UnsupportedAudioFileException, IOException {
        // Setup that's shared between all constructors
        starting_setup(text, choices, answer, is_image);

        // Create question part, then set its size to fit this question type
        create_question_part();
        question_part.setPreferredSize(new Dimension(350, 350));

        // Create choices panel
        create_choices_part(this.is_image);

        // Initialize button to play the audio, and add it to a panel
        JPanel panel_for_button = new JPanel();
        JButton play = new JButton("Play audio");
        panel_for_button.add(play);

        // Set their sizes and bg color
        panel_for_button.setPreferredSize(new Dimension(700, 200));
        panel_for_button.setBackground(new Color(0xf0d9fc));
        play.setPreferredSize(new Dimension(150, 75));

        // Change the button font, add an action listener, and set a unique action command
        play.setFont(font_choice_4);
        play.addActionListener(this);
        play.setActionCommand("play-audio");

        // Load audio
        this.audio = load_audio(path);

        // Add everything to main panel
        this.panel.add(question_part);
        this.panel.add(panel_for_button);
        this.panel.add(choices_part);
        
    }

    public void starting_setup(String text, List<String> choices, String answer, Boolean is_image){
        // Initialize attributes
        this.text = text;
        this.choices = choices;
        this.answer = answer;

        // Create main panel, set its layout and set the bg color
        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));

        // Set boolean value to is_image
        this.is_image = is_image;
    }

    // Method to create the question panel
    public void create_question_part() {
        // Initialize the panel and set its layout, border, size and bg color
        question_part = new JPanel();
        question_part.setLayout(new BorderLayout());
        question_part.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        question_part.setBackground(new Color(0xf0d9fc));

        // Initialize the label, set its font, change its text and set the new size
        JLabel question = new JLabel();
        question.setFont(font_question);

        // Format text then set the label text
        String formatted_text = "<html><div style = 'text-align: center'>" + text + "</div></html>";
        question.setText(formatted_text);

        // Centering for single line questions
        question.setHorizontalAlignment(JLabel.CENTER);

        // Add the label to the panel
        question_part.add(question, BorderLayout.CENTER);
        question_part.setPreferredSize(new Dimension(700, 550));

    }

    public void create_choices_part(Boolean is_image){
        // Initialize the panel, its layout, border, size and bg color
        choices_part.setLayout(new GridBagLayout());
        choices_part.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        choices_part.setPreferredSize(new Dimension(350, 350));
        choices_part.setBackground(new Color(0xf0d9fc));

        // Initialize the smaller one with a 0 by 2 grid layout, where 0 is dynamic
        choices_part_smaller.setLayout(new GridLayout(0, 2));

        // Set the size
        choices_part_smaller.setPreferredSize(new Dimension(600, 300));

        choice_buttons = new ArrayList<>();

        // If the choices are images
        if(is_image){
            // Declare temporary variables
            Image tmp;
            Image tmp_scaled;
            ImageIcon tmp_icon;
            JButton tmp_button;

            // For each path in the choices list
            for (String choice : choices){
                // Load the image into tmp
                tmp = load_image(choice);

                // Scale the image to fit the choices
                tmp_scaled = tmp.getScaledInstance(300, 150, Image.SCALE_DEFAULT);

                // Turn the image into an ImageIcon
                tmp_icon = new ImageIcon(tmp_scaled);

                // Make a button for the choice
                tmp_button = new JButton(tmp_icon);

                // Add action listener to the button
                tmp_button.addActionListener(this);

                // Set action command to check for correct answers later
                tmp_button.setActionCommand(choice);

                // Add to the buttons list and the panel
                choice_buttons.add(tmp_button);
                choices_part_smaller.add(tmp_button);
            }

            // Add everything to the choices_part panel
            choices_part.add(choices_part_smaller);
        }

        else{
            // Add a button for each choice
            for (String choice : choices){
                JButton tmp = new JButton(choice);

                // Add to buttons list
                choice_buttons.add(tmp);
            }

            // Add an action listener to each button and add it to the smaller choices part panel
            for (JButton button : choice_buttons){
                button.addActionListener(this);
                choices_part_smaller.add(button);
                // Apply fonts according to the number of questions
                if (choices.size() == 4) {
                    button.setFont(font_choice_4);
                }
                else {
                    button.setFont(font_choice_2);
                }
            }

            // Add the smaller choices part panel to the main one
            choices_part.add(choices_part_smaller);
        }
    }

    // Method to return Image type from a String path
    public Image load_image(String path){
        Image image_from_path = null;

        try {
            // This gets the image
            image_from_path = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image_from_path;
    }

    // Method to return AudioInputStream type from a String path
    public AudioInputStream load_audio(String path) throws UnsupportedAudioFileException, IOException {
        File audioFile = new File(path);
        // This gets the audio input stream from the path
        return AudioSystem.getAudioInputStream(audioFile);
    }

    // Adds the topic that the question belongs to
    public void add_topic(Topic topic){
        this.topic = topic;
    }

    // Getters and setters
    public void set_gui(GUI gui){
        this.gui = gui;
    }

    public void set_next(Question next) {
        this.next = next;
    }

    public JPanel get_panel() {
        return panel;
    }

    // Reattach listeners to all buttons. Used for questions where the choices are images
    // This is because disabling the buttons like the normal questions will dim the image
    public void reattach_listeners(){
        for (JButton button : choice_buttons){
            button.addActionListener(this);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the source of the button press
        JButton button_pressed = (JButton) e.getSource();

        // If the button is the one to play audio
        if (button_pressed.getActionCommand().equals("play-audio")){
            try {
                // If the audio is already open and is running, restart it and stop it for a second
                if (clip != null && clip.isOpen()) {
                    clip.setFramePosition(0);
                    clip.stop();
                    Thread.sleep(1000);
                } else {
                    // If the audio isn't open yet, get the clip and open it
                    clip = AudioSystem.getClip();
                    clip.open(this.audio);
                }

                // Play the audio
                clip.start();
            } catch (LineUnavailableException | IOException | InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
        // Else, the button is when the user chooses one of the choice buttons
        else {
            // Stops the audio from playing in an audio question
            if (clip != null){
                clip.stop();
            }

            // If the button that's pressed is wrong, change its background to red
            if (!button_pressed.getText().equals(this.answer) && !button_pressed.getActionCommand().equals(this.answer)){
                if (this.is_image){
                    // If it's an image, setting the background to red won't work, so give it a red border instead
                    button_pressed.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
                }
                else{
                    button_pressed.setBackground(Color.RED);
                }
            }

            // Else, the answer is correct and the number of correct answers is incremented
            else {
                topic.increment();
            }

            // Find the button with the correct answer, set it green
            // At the same time, don't break the for loop and disable every button so tbe user can't press again
            for (JButton button : choice_buttons){
                if (button.getText().equals(this.answer) || button.getActionCommand().equals(this.answer)){
                    if (this.is_image){
                        // Same logic as the red border
                        button.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                    }
                    else{
                        button.setBackground(Color.GREEN);
                    }
                }

                // If it's an image, remove the action listener instead of disabling it to prevent the images from dimming
                if (is_image){
                    button.removeActionListener(this);
                }
                else{
                    button.setEnabled(false);
                }
            }

            // Gets the next question
            Question next_question = this.next;

            // Make a new timer
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    // If there is a next question, the scheduled task is to move to the next question
                    if (next_question != null){
                        topic.next_question();
                    }
                    // If there is no next question, then generate the result screen, add it to the gui, then switch to that screen
                    else {
                        ResultScreen result_screen = new ResultScreen(topic.get_correct_answers(), gui);
                        gui.add_result_screen(result_screen);
                        gui.switch_to_screen("result_screen");

                        // If this is a high score, change it
                        if (topic.get_correct_answers() > topic.get_high_score()){
                            topic.set_high_score(topic.get_correct_answers());
                            topic.update_scores();
                        }
                    }

                    // Regardless, reset the button colors and reactivate them for future runs
                    for (JButton button : choice_buttons){
                        // Or reset the borders for questions with image choices
                        if (is_image){
                            button.setBorder(null);
                        }
                        else{
                            button.setBackground(Color.white);
                        }
                        button.setEnabled(true);
                    }

                    // Reattach listeners for questions with image choices
                    if (is_image){
                        reattach_listeners();
                    }

                    // The delay is 4 seconds to let the user look at the correct answer
                }}, 100);


        }
    }
}
