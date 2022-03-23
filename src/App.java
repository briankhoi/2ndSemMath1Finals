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
  private JPanel defaultPanel = new JPanel(); //panel the user sees when they first launch the program
  private JPanel disclaimerPanel = new JPanel(); //panel with the disclaimer message of all the skipped chapters
  private static JPanel testPanel = new JPanel(); //panel with the questions
  private JTextField textField;
  private static JLabel disclaimerMessage = new JLabel("<html>This practice app aims to cover the second semester of Math 1 (Chapters 6-12).<br>Due to coding limitations, unfortunately the majority of content in Chapters 9 and 12 was skipped.<br>Additionally, Chapter 7 was skipped due to many teachers skipping the chapter in their curriculum.<br> We apologize for the inconvenience and hope that despite the flaws, this program will be helpful in you passing the<br>Math 1 2nd Semester Finals.</html>");
  private static JButton disclaimer = new JButton("READ ME");
  private static JButton start = new JButton("Start");
  private static JButton button = new JButton("Submit");
  private static JButton back = new JButton("Back");
  private static ArrayList<LinearEq> obj = new ArrayList<>();
  private CardLayout cardSystem;
  private JPanel cardPanel;
  private static ArrayList<Chapter8>testing = new ArrayList<>();
  private ArrayList<Question>Questions = new ArrayList<>();

  //TO-DO: MAKE GET METHODS FOR THE STATIC VARIABLES
  
  
  App() {
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
    defaultPanel.add(start);
    defaultPanel.setVisible(true);
    pack();

    //modifying the question screen
    testPanel.setLayout(new BoxLayout(testPanel, BoxLayout.Y_AXIS));

    testPanel.add(back);
    testPanel.add(button);

    //modifying the disclaimer/skipped chapter screen
    disclaimerPanel.setLayout(new BoxLayout(disclaimerPanel, BoxLayout.Y_AXIS));
    disclaimerPanel.add(disclaimerMessage);
    disclaimerPanel.add(back);
    
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
          cardSystem.show(cardPanel, "" + 2);
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
          testPanel.setVisible(true);
          for (int i = 0; i < 3; i++) {
            generateChapter6();
          }
          pack();
          }
        }
    );

    //executes when back button is pressed
    back.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          System.out.println("working back");
          disclaimerPanel.setVisible(false);
          testPanel.setVisible(false);
          defaultPanel.setVisible(true);
          pack();
          }
        }
    );

    cardPanel.add(defaultPanel, "1");
    cardPanel.add(disclaimerPanel, "2");
    cardPanel.add(testPanel, "3");
    getContentPane().add(cardPanel, BorderLayout.NORTH);
    this.add(cardPanel);
    
    this.setVisible(true);
    this.revalidate();
    //current.getTextField().addFocusListener(this);
  }

  //executes when the submit button is called?
  public void actionPerformed(ActionEvent e) {
    for (int i = 0; i < obj.size(); i++) {
      System.out.println(obj.get(i).checkAnswer());
    }       
  }

  public void generateChapter1() {
    LinearEq current = new LinearEq();
    obj.add(current);
    testPanel.add(current.getPanel());
    Questions.add(current);
  }

  public void generateChapter8() {
    Chapter8 current = new Chapter8();
    testPanel.add(current.getPanel());
    Questions.add(current);
    System.out.println("ch8");
  }

  public void generateChapter6() {
    expTable current = new expTable();
    testPanel.add(current.getPanel());
    Questions.add(current);
    System.out.println("ch6");
  }

}


