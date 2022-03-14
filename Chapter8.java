import javax.swing.*;

public class Chapter8 extends Question {
  private int a;
  private int b;
  private int c;
  private int x;
  private int y;
  private int degrees;
  
  Chapter8() {
    super();
    x = (int) (Math.random() * 5 + 6);
    y = (int) (Math.random() * 5 + 1);
  }

  public String generateLineSegmentProblem() {
    int determiner = (int)(Math.random() * 2 + 1);
    if (determiner == 1) { 
      setAnswer(x - y);
      return "What is the value of BC if AC is equal to " + x + " and AB is equal to " + y + " ?";
    } else {
      setAnswer(x + y);
      return "What is the value of AC if AB is equal to " + x + " and BC is equal to " + y + " ?";
    }
  }

  public String 
}