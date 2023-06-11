package OOP;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TopicScreen extends Screen {
    private final JLabel info;
    private final JPanel info_panel;
    private Boolean unlocked = false;
    private final GUI gui;
    private int correct_total = 0;
    private final List<JLabel> high_scores = new ArrayList<>();
    private final List<Topic> topics;


    public TopicScreen(GUI gui) throws UnsupportedAudioFileException, IOException {
        this.gui = gui;

        // Initialize panel and layout
        setup();

        // Create new topic_list
        TopicList topic_list = new TopicList(gui, this);
        topics = topic_list.get_topics();

        // Initialize topics_panel
        JPanel topics_panel = new JPanel();
        topics_panel.setLayout(new GridLayout(0, 2)); // 2 columns, dynamic rows

        // Initialize topics_title label and its font
        JLabel topic_title = new JLabel("Choose a topic!");
        topic_title.setAlignmentX(Component.CENTER_ALIGNMENT);
        Font title_font = new Font("Georgia", Font.BOLD, 50);
        topic_title.setFont(title_font);

        // Add stuff to main panel
        panel.add(Box.createVerticalStrut(30));
        panel.add(topic_title);
        panel.add(Box.createVerticalStrut(50));

        // Create and add topic panels
        for (Topic topic : topics) {
            JPanel topicPanel = create_topic_panel(topic);
            topics_panel.add(topicPanel);
        }

        // Initialize scores from text file
        initialize_scores();

        // Create panel for the info, set its layout and bg color
        info_panel = new JPanel();
        info_panel.setLayout(new GridBagLayout());
        info_panel.setBackground(new Color(0xf0d9fc));

        // Create new JLabel for info
        info = new JLabel("<html><div style = 'text-align: center'>Unlock the secret topic<br>by answering 30 questions<br>correctly in total.<br>Current: 0</div></html>");

        // Create new font and set the label's font
        Font info_font = new Font("Georgia", Font.BOLD, 20);
        info.setFont(info_font);

        // Add label to panel
        info_panel.add(info);

        // Add info panel to topics_panel
        topics_panel.add(info_panel);

        // Add topics_panel into the main panel
        panel.add(topics_panel);

        // Add scroll pane for the topics
        JScrollPane scroll_pane = new JScrollPane(topics_panel);
        scroll_pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll_pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(scroll_pane, BorderLayout.CENTER);
    }

    public void increment(){
        this.correct_total++;
        if (correct_total < 30){
            info.setText("<html><div style = 'text-align: center'>Unlock the secret topic<br>by answering 30 questions<br>correctly in total.<br>Current: " + correct_total + "</div></html>");
        }
        else {
            info.setText("Secret topic unlocked");
            unlocked = true;
        }
        info_panel.removeAll();
        info_panel.add(info);
    }

    public void initialize_scores(){
        List<String> scores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Brandon Salim\\IdeaProjects\\Data_structures\\src\\OOP\\high_scores.txt"))) {
            for (int i = 0; i < topics.size() - 1; i++){
                // Assign the line to a temporary variable
                scores.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < topics.size() - 1; i++){
            high_scores.get(i).setText("High score: " + scores.get(i));
            topics.get(i).set_high_score(Integer.parseInt(scores.get(i)));
        }
    }

    public void reset_scores(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Brandon Salim\\IdeaProjects\\Data_structures\\src\\OOP\\high_scores.txt"))) {
            for (JLabel high_score : high_scores) {
                high_score.setText("High score: 0");

                writer.write("0");
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update_scores(){
        JLabel tmp_label;
        int tmp_high_score;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Brandon Salim\\IdeaProjects\\Data_structures\\src\\OOP\\high_scores.txt"))) {
            for (int i = 0; i < high_scores.size(); i++){
                tmp_label = high_scores.get(i);
                tmp_high_score = topics.get(i).get_high_score();
                tmp_label.setText("High score: " + tmp_high_score);

                writer.write(String.valueOf(tmp_high_score));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JPanel create_topic_panel(Topic topic) {
        // Initialize topic_panel
        JPanel topic_panel = new JPanel();
        topic_panel.setLayout(new BoxLayout(topic_panel, BoxLayout.Y_AXIS));
        topic_panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Set bg color for topic_panel
        topic_panel.setBackground(new Color(0xf0d9fc));

        // Initialize small_topic_panel
        JPanel small_topic_panel = new JPanel();
        small_topic_panel.setLayout(new BoxLayout(small_topic_panel, BoxLayout.Y_AXIS));
        small_topic_panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Initialize topic name label
        JLabel topic_name = new JLabel(topic.get_name());
        topic_name.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Set font for name label
        Font name_font = new Font("Georgia", Font.BOLD, 15);
        topic_name.setFont(name_font);

        // Initialize topic icon, which is a JLabel of an image
        JLabel topic_icon = new JLabel(new ImageIcon(topic.get_icon()));
        topic_icon.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create label for high score, and add them to the list to be able to reference them later
        JLabel high_score = new JLabel("High score: " + topic.get_high_score());
        high_score.setAlignmentX(Component.CENTER_ALIGNMENT);
        high_scores.add(high_score);

        // Add stuff to small topic panel then add that to the topic panel
        small_topic_panel.add(Box.createVerticalStrut(20));
        small_topic_panel.add(topic_name);
        small_topic_panel.add(Box.createVerticalStrut(20));
        small_topic_panel.add(topic_icon);
        small_topic_panel.add(Box.createVerticalStrut(20));
        small_topic_panel.add(high_score);
        small_topic_panel.add(Box.createVerticalStrut(20));

        topic_panel.add(small_topic_panel);

        // Set topic panel size
        Dimension size = new Dimension(300, 340);
        topic_panel.setPreferredSize(size);
        topic_panel.setMaximumSize(size);

        // Set small topic panel size
        Dimension size2 = new Dimension(300, 320);
        small_topic_panel.setPreferredSize(size2);
        small_topic_panel.setMaximumSize(size2);

        // Black border for small topic panel
        small_topic_panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        // Add mouse listener
        topic_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (topic.get_name().equals("???") && unlocked){
                    gui.switch_to_screen("rickroll");
                }
                else{
                    // Randomize the questions of the selected class
                    JPanel question_panels = topic.randomize_panels();

                    // Add the card layout panel of the randomized questions to the gui
                    gui.add_questions(question_panels);

                    // Switch to the newly added panel
                    gui.switch_to_screen("questions");
                }
            }
        });

        return topic_panel;


    }
}
