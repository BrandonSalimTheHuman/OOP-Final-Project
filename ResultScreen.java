package OOP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultScreen extends Screen implements ActionListener {
    // Declare attributes
    private final GUI gui;

    public ResultScreen(int correct_answers, GUI gui){
        // Initialize gui
        this.gui = gui;

        // Initialize panel and layout
        setup();

        // Initialize label to show results and add font
        int total_questions = 10;

        JLabel text = new JLabel("<html><div style = 'text-align: center'>You answered<br><br>" + correct_answers + "<br><br>out of<br><br>" + total_questions + "<br><br>questions correctly</div></html>");
        Font font = new Font("Haettenschweiler", Font.BOLD, 55);
        text.setFont(font);

        // Initialize panel for the text with gridbaglayout so the label is centered
        // Also set the size and bg color, then add the text to the panel
        JPanel text_panel = new JPanel();
        text_panel.setLayout(new GridBagLayout());
        text_panel.setPreferredSize(new Dimension(700, 600));
        text_panel.setBackground(new Color(0xf0d9fc));
        text_panel.add(text);

        // Initialize the button to go back to the menu
        JButton back_to_menu = new JButton("Back to menu");
        Font font2 = new Font("Mona Lisa Solid ITC TT", Font.BOLD, 40);
        back_to_menu.setFont(font2);

        // Add action listener to button
        back_to_menu.addActionListener(this);

        // Initialize panel for the button so that the button is centered
        // ALso set the size and bg color
        JPanel button_panel = new JPanel();
        button_panel.setLayout(new GridBagLayout());
        button_panel.setPreferredSize(new Dimension(700, 300));
        button_panel.setBackground(new Color(0xf0d9fc));

        button_panel.add(back_to_menu);


        // Add both panels to the main panel
        panel.add(text_panel);
        panel.add(button_panel);
    }

    // Button goes back to the topic screen
    @Override
    public void actionPerformed(ActionEvent e) {
        gui.switch_to_screen("topic_screen");
    }
}
