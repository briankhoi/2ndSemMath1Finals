import org.apache.commons.math3.fraction.FractionFormat;
import org.apache.commons.math3.fraction.Fraction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Question {
    private JTextField textField;
    private JLabel label;
    private double answer; //number answer
    private String response; //response incase we want an FRQ answer like y=2x+1
    private String explanation; //generated response incase user gets question wrong
    public DecimalFormat DFormatter = new DecimalFormat("#0.000"); //these two help with converting fraction input to recognized numeric values - idk if we should make them private or not, public for now cause it's easier to test with 
    public FractionFormat FFormatter = new FractionFormat();
  
    //constructor
    Question() {
        textField = new JTextField();
        label = new JLabel();
        
        //makes it so that when the user clicks on a textfield, the text inside the textfield disappears
        textField.addMouseListener(new MouseAdapter(){
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

    public double getAnswer() {
        return this.answer;
    }

    public String getResponse() {
        return this.response;
    }

    public String getExplanation() {
      return this.explanation;
    }

    //mutator (set) methods for private variables
    public void setAnswer(double num) {
      this.answer = num;
    }

    public void setResponse(String resp) {
      this.response = resp;
    }

    public void setExplanation(String str) {
      this.explanation = str;
    }


    public boolean checkAnswer() { //temp fix try catch for fraction and change to fraction only
      if (this.textField.getText().equals("")) {
        return false;
      } else {
        Fraction f = FFormatter.parse(getTextField().getText());
        double value = Math.round(f.getNumerator() / f.getDenominator() * 1000) / 1000.0;
        return this.answer == value;
      }
    }
    
}


