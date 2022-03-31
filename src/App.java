import javax.swing.*;
import java.awt.*;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class App extends JFrame implements ActionListener {
  private JPanel defaultPanel; //panel the user sees when they first launch the program
  private JPanel disclaimerPanel; //panel with the disclaimer message of all the skipped chapters
  private JPanel questionPanel; //panel with the questions
  private JTextField textField;
  private JLabel disclaimerMessage;
  private JLabel warmupMsg;
  private JLabel Chapter6Msg;
  private JLabel Chapter8Msg;
  private JLabel Chapter10Msg;
  private JLabel Chapter11Msg;
  private JLabel scoreLabel;
  private JButton disclaimer;
  private JButton start;
  private JButton button;
  private JButton home;
  private ArrayList<Question>Questions;
  private JScrollPane scroll;
  private int score;
  

  
  App() {
    defaultPanel = new JPanel();
    disclaimerPanel = new JPanel();
    questionPanel = new JPanel();
    Questions = new ArrayList<>();
    disclaimer = new JButton("READ ME");
    start = new JButton("Start");
    button = new JButton("Submit");
    home = new JButton("Home");
    disclaimerMessage = new JLabel("<html>This practice app aims to cover the second semester of Math 1 (Chapters 6-12).<br>Due to coding limitations, unfortunately the majority of content in Chapters 9 and 12 was skipped.<br>Additionally, Chapter 7 was skipped due to many teachers skipping the chapter in their curriculum.<br> We apologize for the inconvenience and hope that despite the flaws, this program will be helpful in you passing the<br>Math 1 2nd Semester Finals.</html>");
    warmupMsg = new JLabel("Chapter 1: Linear Functions");
    Chapter6Msg = new JLabel("Chapter 6: Exponential Functions");
    Chapter8Msg = new JLabel("Chapter 8: Lines and Angles");
    Chapter10Msg = new JLabel("placeholder");
    Chapter11Msg = new JLabel("placeholder1");
    scoreLabel = new JLabel();
    score = 0;
    scroll = new JScrollPane(questionPanel);
    scroll.setPreferredSize(new Dimension(300,300));
    scroll.getVerticalScrollBar().setUnitIncrement(6);
    
    //modifying the frame
    this.setDefaultCloseOperation(App.EXIT_ON_CLOSE);
    this.add(defaultPanel);
    this.setTitle("Math 1 2nd Semester Finals Practice App");
    this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

    //start screen
    defaultPanel.add(disclaimer);
    defaultPanel.add(start, 0);
    defaultPanel.setVisible(true);

    
    //modifying the question screen
    questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));
   
    //modifying the disclaimer/skipped chapter screen
    disclaimerPanel.setLayout(new BoxLayout(disclaimerPanel, BoxLayout.Y_AXIS));
    disclaimerPanel.add(disclaimerMessage);
    disclaimerPanel.add(home);


    questionPanel.add(warmupMsg);
    for (int i = 0; i < 3; i++) {
      generateChapter1();
    }
    questionPanel.add(Chapter6Msg);
    for (int i = 0; i < 5; i++) {
      generateChapter6();
    }
    questionPanel.add(Chapter8Msg);
    for (int i = 0; i < 5; i++) {
      generateChapter8();
    }
    questionPanel.add(Chapter10Msg);
    for (int i = 0; i < 5; i++) {
      generateChapter10();
    }
    
    questionPanel.add(button);
    questionPanel.add(scoreLabel);

    //submit button
    button.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          for (int i = 0; i < Questions.size(); i++) {
            Questions.get(i).answerUpdater();
            if (Questions.get(i).getBackground().equals( Color.GREEN)) {
              score++;
            }
            scoreLabel.setText("" + score);
          }
        }
      }
    );

    //executes when disclaimer/README button is pressed
    disclaimer.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          defaultPanel.setVisible(false);
          disclaimerPanel.setVisible(true);  
          setContentPane(disclaimerPanel);
          }
        }
    );

    //starts the generation of questions
    start.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          System.out.println("working start");
          defaultPanel.setVisible(false);
          setContentPane(scroll);
          }
        }
    );

    //executes when home button is pressed
    home.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          System.out.println("working home");
          disclaimerPanel.setVisible(false);
          questionPanel.setVisible(false);
          defaultPanel.setVisible(true);
          //pack();
          }
        }
    );
  
    this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
    this.setVisible(true);
    this.revalidate();
    //current.getTextField().addFocusListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    System.out.println("");
  }

  public void generateChapter1() {
    LinearEq current = new LinearEq();
    questionPanel.add(current);
    Questions.add(current);
  }

  public void generateChapter8() {
    Chapter8 current = new Chapter8();
    questionPanel.add(current);
    Questions.add(current);
    System.out.println("ch8");
  }

  public void generateChapter6() {
    expTable current = new expTable();
    questionPanel.add(current);
    Questions.add(current);
    this.pack();
    System.out.println("ch6");
  }

  public void generateChapter10() {
    Chapter10 current = new Chapter10();
    questionPanel.add(current);
    Questions.add(current);
    System.out.println("ch10");
  }

}


