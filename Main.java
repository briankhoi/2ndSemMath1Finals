import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JFrame implements ActionListener {
  private JPanel defaultPanel = new JPanel(); //panel the user sees when they first launch the program
  private JPanel disclaimerPanel = new JPanel(); //panel with the disclaimer message of all the skipped chapters
  private static JPanel testPanel = new JPanel(); //panel with the questions
  private JTextField textField;
  private static JLabel disclaimerMessage = new JLabel("<html>test<br>test1</html>");
  private static JButton disclaimer = new JButton("READ ME");
  private static JButton start = new JButton("Start");
  private static JButton button = new JButton("Submit");
  private static JButton back = new JButton("Back");
  private static ArrayList<LinearEq> obj = new ArrayList<>();
  private CardLayout cardSystem;
  private JPanel cardPanel;

  //TO-DO: MAKE GET METHODS FOR THE STATIC VARIABLES
  
  
  Main() {
    //card layout system which helps navigate between pages
    cardSystem = new CardLayout();
    cardPanel = new JPanel();
    cardPanel.setLayout(cardSystem);
    
    //modifying the frame
    this.setDefaultCloseOperation(Main.EXIT_ON_CLOSE);
 
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

    //modifying the disclaimer/skipped chapter screen
    disclaimerPanel.setLayout(new BoxLayout(disclaimerPanel, BoxLayout.Y_AXIS));
    disclaimerPanel.add(back);
    disclaimerPanel.add(disclaimerMessage);
    
    button.addActionListener(this);

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
    //current.getTextField().addFocusListener(this);
  }

  //executes when the submit button is called?
  public void actionPerformed(ActionEvent e) {
    for (int i = 0; i < obj.size(); i++) {
      System.out.println(obj.get(i).checkAnswer());
    }       
  }



  

  
  public static void main(String[] args) {
    Main frame = new Main();

    
      for (int i = 0; i < 3; i++) {
        LinearEq current = new LinearEq();
          obj.add(current);
          current.getLabel().setText(current.generateProblem1());
          current.getLabel().setPreferredSize(new Dimension(260,40));
          current.getTextField().setText("test");
          current.getTextField().setPreferredSize(new Dimension(250,60));
          testPanel.add(current.getLabel());
          testPanel.add(current.getTextField());
          
          System.out.println(i);
        }
        testPanel.add(button);
        frame.pack();
        testPanel.revalidate();
    }
  
}


