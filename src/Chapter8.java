import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

public class Chapter8 extends Question { //probably inefficient to initalize all the variables since only one equation/method is being used per object 
  private double x1;
  private double y1;
  private double x2;  
  private double y2;
  private double degrees;
  private String coordinatePoint;
  private ImageIcon varDiagramObtuse = new ImageIcon("images/varDiagramObtuse.png");
  private ImageIcon varDiagramAcute = new ImageIcon("images/varDiagramAcute.png");
  private ImageIcon lineSegment = new ImageIcon("images/lineSegment.png");

  private int determiner;
  
  Chapter8() {
    super();
    this.x1 = (int) (Math.random() * 5 + 1);
    this.y1 = (int) (Math.random() * 5 + 1);
    this.x2 = (int) (Math.random() * 5 + 6);
    this.y2 = (int) (Math.random() * 5 + 6);
    this.degrees = (int) (Math.random() * 85 + 2);
    this.coordinatePoint = "(" + this.x1 +", " + this.y1 + ") and (" + this.x2 + ", " + this.y2 + ")";
    this.determiner = (int) (Math.random() * 2 + 1);
    this.problemGen();
  }

  
  public void problemGen() {
    int problem = (int) (Math.random() * 5 + 1);
    if (problem == 1) {
      this.setLabel(generateLineSegment());
    } else if (problem == 2) {
      this.setLabel(generateComSupAngles());
      } else if (problem == 3) {
      this.setLabel(generateMidpoint());
      } else if (problem == 4) {
      this.setLabel(generateDistanceFormula());
      } else {
      this.setLabel(generateVariableAngles());
      }
  }
  
  public String generateLineSegment() { 
   
    getLabel().setIcon(this.lineSegment);
    if (this.determiner == 1) { 
      setAnswer(this.x2 - this.y1);
      return "<html>Given the line segment AC with point B in the middle, what is the value of BC if AC is equal <br> to " + this.x2 + " and AB is equal to " + this.y1 + " ?</html>";
    } else {
      setAnswer(this.x2 + this.y1);
      return "<html>Given the line segment AC with point B in the middle,<br>what is the value of AC if AB is equal to " + this.x2 + " and BC is equal to " + this.y1 + " ?</html>";
    }
  }

  public String generateComSupAngles() {
    if (this.determiner == 1) {
      setAnswer(90 - this.degrees);
      return "If A and B are complementary angles, what is the value of B if A is " + this.degrees + " degrees?";
    } else {
      setAnswer(180 - this.degrees);
      return "If A and B are supplementary angles, what is the value of B if A is " + this.degrees + " degrees?";
    }
  }

  public String generateMidpoint() {
    setAnswer(((this.x1 + this.x2) / 2 + (this.y1 + this.y2) / 2));
    return "What is the sum of the coordinates of the midpoint between " + this.coordinatePoint + " ?"; 
  }

  public String generateDistanceFormula() {
    setAnswer(Math.sqrt(Math.pow(this.x2 - this.x1, 2) + Math.pow(this.y2 - this.y1, 2)));
    return "What is the distance between the coordinates " + this.coordinatePoint + " ? Round your answer to the nearest whole number.";
  }

  public String generateVariableAngles() {
    int fullDeg = (int) (Math.random() * 30) + 110;
    if (this.determiner == 1) {
      setAnswer((fullDeg - this.x2 - this.y2)/(this.x1 + this.y1));
        this.getLabel().setIcon(this.varDiagramObtuse);
        //scaleImage("images/varDiagramObtuse.png", getLabel());
      return "<html>If angle ABC is equal to " + fullDeg + " degrees and ABD is equal to " + this.x1 + "x + " + this.x2 + ",<br>while CBD is equal to " + this.y1 + "x + " + this.y2 + ", what is the value of angle CBD?</html>";
    } else {
      setAnswer((this.degrees - this.x2 - this.y2)/(this.x1 + this.y1));
      //scaleImage("images/varDiagramAcute.png", getLabel());
      this.getLabel().setIcon(this.varDiagramAcute);
      return "<html>If angle ABC is equal to " + this.degrees + " degrees and ABD is equal to " + this.x1 + "x + " + this.x2 + ",<br>while CBD is equal to " + this.y1 + "x + " + this.y2 + ", what is the value of angle CBD?</html>";
    }
  }

  /*private void scaleImage(String location, JLabel label){
        ImageIcon icon = new ImageIcon(location);
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        label.setIcon(scaledIcon);

    }*/
}