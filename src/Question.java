import org.apache.commons.math3.fraction.FractionFormat;
import org.apache.commons.math3.fraction.Fraction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Question extends JPanel {
    private JTextField textField;
    private JLabel label;
    private JLabel imageLabel;
    private double answer; //number answer
    private DecimalFormat DFormatter = new DecimalFormat("#0.000"); 
    private FractionFormat FFormatter = new FractionFormat();
  
    //constructor
    Question() {
    
      this.textField = new JTextField();
      this.label = new JLabel();
      this.imageLabel = new JLabel();
      
      this.textField.setPreferredSize(new Dimension(180,60));
      this.textField.setText("Enter your answer here");
      this.label.setPreferredSize(new Dimension(400,180));

      this.add(this.label);
      this.add(this.textField);
      this.add(this.imageLabel);

      this.setVisible(true);
        //makes it so that when the user clicks on a textfield, the text inside the textfield disappears
      this.textField.addMouseListener(new MouseAdapter(){
          @Override
          public void mouseClicked(MouseEvent e){
              textField.setText("");
          }
      });
    }

    //accessor (get) methods for private variables
    
  
    public JTextField getTextField(){
        return this.textField;
    }

    public JLabel getLabel() {
        return this.label;
    }

    public JLabel getImageLabel() {
      return this.imageLabel;
    }
  
    public double getAnswer() {
        return this.answer;
    }

    public DecimalFormat getDFormatter() {
      return this.DFormatter;
    }

    public FractionFormat getFFormatter() {
      return this.FFormatter;
    }

    //mutator (set) methods for private variables
    public void setLabel(String str) {
      this.label.setText(str);
    }
    
    public void setAnswer(double num) {
      this.answer = num;
    }

    public boolean checkAnswer() { //double try catch to take both fraction and numeric inputs
      if (this.textField.getText().equals("")) {
        return false;
      } else {
        try {
          Fraction f = FFormatter.parse(getTextField().getText());
          double value = Math.round(f.getNumerator() / f.getDenominator() * 1000) / 1000.0;
          return this.answer == value;
        } catch (Exception er) {
          try {
            return this.answer == Double.parseDouble(DFormatter.format(Double.parseDouble(this.textField.getText())));
          } catch (Exception err) {
              return false;
          }
        }
      }
    }

    public void answerUpdater() {
      if (checkAnswer()) {
        this.textField.setBackground(Color.GREEN);
      } else {
        this.textField.setBackground(Color.RED);
      }
    } 
    
}


