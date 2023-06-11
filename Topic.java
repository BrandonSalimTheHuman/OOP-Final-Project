package OOP;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Topic {
    private final String name;
    private Image icon;
    private final List<Question> questions = new ArrayList<>();
    private int current = 0;
    private final CardLayout card_layout_questions = new CardLayout();
    private final JPanel questions_panel = new JPanel(card_layout_questions);
    private final GUI gui;
    private final TopicScreen topic_screen;
    private int correct_answers = 0;
    private int high_score;

    // Constructor
    public Topic(String name, String path, GUI gui, TopicScreen topic_screen) {
        this.gui = gui;
        this.topic_screen = topic_screen;
        this.name = name;
        try {
            // Reading the image based on its path
            Image original_icon = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(path)));
            // Resizing the image
            this.icon = original_icon.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        }
        // It won't let me read the image unless I catch this exception
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Add new question to a topic
    public void add_question(Question question){
        questions.add(question);
    }


    // Method to randomize questions and returning a panel of the randomized question
    public JPanel randomize_panels(){
        // Shuffle the order of all questions
        Collections.shuffle(questions);

        // Reset the questions_panel if user play multiple times
        questions_panel.removeAll();

        // Reset question counter and the counter for correct answers
        current = 0;
        correct_answers = 0;

        // No. of questions to be randomized
        int num_of_questions = 10;

        for (int i = 0; i < num_of_questions; i++){
            // For every question except for the last one, make the next question the current one's next
            if (i != num_of_questions - 1) {
                questions.get(i).set_next(questions.get(i + 1));
            }
            // Add the topic and gui the question belongs to
            questions.get(i).add_topic(this);
            questions.get(i).set_gui(get_gui());

            // Add the question to questions_panel
            questions_panel.add(questions.get(i).get_panel(), String.valueOf(i));
        }

        // Every other question that wasn't touched by the previous for loop has their next set to null
        for (int i = num_of_questions - 1; i <= questions.size() - 1; i++){
            questions.get(i).set_next(null);
        }

        // Shows the first question
        next_question();


        return questions_panel;
    }

    public void next_question(){
        // Shows the next question in the card layout
        card_layout_questions.show(questions_panel, String.valueOf(current));
        current++;
    }

    // Method to increment the correct answers form the question class
    public void increment(){
        this.correct_answers++;
        topic_screen.increment();
    }

    // Getter and Setter
    public int get_correct_answers(){
        return this.correct_answers;
    }

    public String get_name() {
        return name;
    }

    public Image get_icon() {
        return icon;
    }

    public GUI get_gui() {
        return gui;
    }

    public int get_high_score() {
        return high_score;
    }

    public void set_high_score(int high_score) {
        this.high_score = high_score;
    }

    public void update_scores(){
        topic_screen.update_scores();
    }
}
