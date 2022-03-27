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
  private JPanel startPanel; //panel with the questions
  private JPanel QPanel2;
  private JPanel QPanel3;
  private JPanel QPanel4;
  private JPanel QPanel5;
  private JPanel buttonPanel;
  private JTextField textField;
  private JLabel disclaimerMessage;
  private JLabel warmupMsg;
  private JLabel Chapter6Msg;
  private JLabel Chapter8Msg;
  private JLabel Chapter10Msg;
  private JLabel Chapter11Msg;
  private JButton disclaimer;
  private JButton start;
  private JButton button;
  private JButton back;
  private JButton next;
  private JButton home;
  private CardLayout cardSystem;
  private JPanel cardPanel;
  private ArrayList<Question>Questions;
  private int currentCard;
  
  App() {
    defaultPanel = new JPanel();
    disclaimerPanel = new JPanel();
    startPanel = new JPanel();
    QPanel2 = new JPanel();
    QPanel3 = new JPanel();
    QPanel4 = new JPanel();
    QPanel5 = new JPanel();
    buttonPanel = new JPanel();
    Questions = new ArrayList<>();
    disclaimer = new JButton("READ ME");
    start = new JButton("Start");
    button = new JButton("Submit");
    back = new JButton("Back");
    next = new JButton("Next");
    home = new JButton("Home");
    disclaimerMessage = new JLabel("<html>This practice app aims to cover the second semester of Math 1 (Chapters 6-12).<br>Due to coding limitations, unfortunately the majority of content in Chapters 9 and 12 was skipped.<br>Additionally, Chapter 7 was skipped due to many teachers skipping the chapter in their curriculum.<br> We apologize for the inconvenience and hope that despite the flaws, this program will be helpful in you passing the<br>Math 1 2nd Semester Finals.</html>");
    warmupMsg = new JLabel("Chapter 1: Linear Functions");
    Chapter6Msg = new JLabel("Chapter 6: Exponential Functions");
    Chapter8Msg = new JLabel("Chapter 8: Lines and Angles");
    Chapter10Msg = new JLabel("placeholder");
    Chapter11Msg = new JLabel("placeholder1");
    
    currentCard = 1;
    
    //card layout system which helps navigate between pages
    cardSystem = new CardLayout();
    cardPanel = new JPanel();
    cardPanel.setLayout(cardSystem);
    
    //modifying the frame
    this.setDefaultCloseOperation(App.EXIT_ON_CLOSE);
 
    this.add(defaultPanel);
    this.setTitle("Math 1 2nd Semester Finals Practice App");
    
    //modifying the start screen
    getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    defaultPanel.add(disclaimer);
    defaultPanel.add(start, 0);
    defaultPanel.setVisible(true);
    pack();
    buttonPanel.add(next);
    buttonPanel.add(back);
    buttonPanel.add(button);

    //modifying the question screen
    startPanel.setLayout(new BoxLayout(startPanel, BoxLayout.Y_AXIS));
    //startPanel.add(warmupMsg);
    startPanel.add(home);
    startPanel.add(buttonPanel);
    QPanel2.add(buttonPanel);
    QPanel3.add(buttonPanel);
    QPanel4.add(buttonPanel);
    QPanel5.add(buttonPanel);
    //modifying the disclaimer/skipped chapter screen
    disclaimerPanel.setLayout(new BoxLayout(disclaimerPanel, BoxLayout.Y_AXIS));
    disclaimerPanel.add(disclaimerMessage);
    disclaimerPanel.add(home);
    
    button.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          for (int i = 0; i < Questions.size(); i++) {
            Questions.get(i).answerUpdater();
          }
          }
        }
    );

    //executes when disclaimer/README button is pressed
    disclaimer.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          cardSystem.show(cardPanel, "b");
          System.out.println("pack successful");
          }
        }
    );

    //executes when start button is pressed
    start.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          System.out.println("working start");
          defaultPanel.setVisible(false);
          startPanel.setVisible(true);
          for (int i = 0; i < 3; i++) {
            generateChapter8();
          }
          pack();
          }
        }
    );

    //executes when home button is pressed
    home.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          System.out.println("working home");
          disclaimerPanel.setVisible(false);
          startPanel.setVisible(false);
          defaultPanel.setVisible(true);
          pack();
          }
        }
    );

    next.addActionListener( 
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          if (currentCard < 5) {
            currentCard += 1;
            cardSystem.show(cardPanel, "" + (currentCard));
          }
        }
      }
    );

    back.addActionListener( 
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          if (currentCard > 1) {
            currentCard -= 1;
            cardSystem.show(cardPanel, "" + (currentCard));
          }
        }
      }
    );
    

    cardPanel.add(defaultPanel, "a");
    cardPanel.add(disclaimerPanel, "b");
    cardPanel.add(startPanel, "1");
    cardPanel.add(QPanel2, "2");
    cardPanel.add(QPanel3, "3");
    cardPanel.add(QPanel4, "4");
    cardPanel.add(QPanel5, "5");
    getContentPane().add(cardPanel, BorderLayout.NORTH);
    this.add(cardPanel);
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
    startPanel.add(current.getPanel());
    Questions.add(current);
  }

  public void generateChapter8() {
    Chapter8 current = new Chapter8();
    startPanel.add(current.getPanel());
    Questions.add(current);
    System.out.println("ch8");
  }

  public void generateChapter6() {
    expTable current = new expTable();
    startPanel.add(current.getPanel());
    Questions.add(current);
    System.out.println("ch6");
  }

}


