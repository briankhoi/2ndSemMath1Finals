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
    private JPanel panel;
    private JTextField textField;
    private JLabel label;
    private double answer; //number answer
    private String explanation; //generated response incase user gets question wrong
    public DecimalFormat DFormatter = new DecimalFormat("#0.000"); //these two help with converting fraction input to recognized numeric values - idk if we should make them private or not, public for now cause it's easier to test with 
    public FractionFormat FFormatter = new FractionFormat();
  
    //constructor
    Question() {
      this.panel = new JPanel();
      this.textField = new JTextField();
      this.label = new JLabel();
      
      this.textField.setPreferredSize(new Dimension(120,60));
      this.textField.setText("Enter your answer here");
      this.label.setPreferredSize(new Dimension(400,180));

      this.panel.add(this.label);
      this.panel.add(this.textField);

      this.panel.setVisible(true);
        //makes it so that when the user clicks on a textfield, the text inside the textfield disappears
      this.textField.addMouseListener(new MouseAdapter(){
          @Override
          public void mouseClicked(MouseEvent e){
              textField.setText("");
          }
      });
    }

    //accessor (get) methods for private variables
    public JPanel getPanel() {
      return this.panel;
    }
  
    public JTextField getTextField(){
        return this.textField;
    }

    public JLabel getLabel() {
        return this.label;
    }

    public double getAnswer() {
        return this.answer;
    }

    public String getExplanation() {
      return this.explanation;
    }

    //mutator (set) methods for private variables
    public void setLabel(String str) {
      this.label.setText(str);
    }
    
    public void setAnswer(double num) {
      this.answer = num;
    }

    public void setExplanation(String str) {
      this.explanation = str;
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


