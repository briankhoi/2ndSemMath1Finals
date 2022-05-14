import javax.swing.*;

public class Chapter10 extends Question {
  int m = 0;
  int b = 0;
  int parallelDistance = 0;
  double perpSlope = 0;
  int perpB = 0;
  double perpXAnswer = 0;
  double perpYAnswer = 0;
  int xImageType = 0;
  int angleA = 0;
  int xOrY = 0;
  private ImageIcon image1 = new ImageIcon("images/chapter10ImageType1.png");
  private ImageIcon image2 = new ImageIcon("images/chapter10ImageType2.png");

  
  Chapter10() {
    super();
    m = (int)(Math.random() * 10 + 1);
    b = (int)(Math.random() * 15 + 1);
    parallelDistance = (int)(Math.random() * 10 + 1);
    perpSlope = (double) -1 / m;
    perpB = (int)(Math.random() * 10 + 1);
    perpXAnswer = (perpB - b) * (m + perpSlope);
    perpYAnswer = m * perpXAnswer + b;
    xImageType = (int)(Math.random() * 2 + 1);
    angleA = (int)(Math.random() * 80 + 1);
    xOrY = (int)(Math.random() * 2 + 1);
    problemGen();
  }

  public void problemGen() {
    int determine = (int) (Math.random() * 3 + 1);
    if (determine == 1) {
      this.setLabel(xImageProblem());
    } else if (determine == 2) {
      this.setLabel(parallelProblem());
    } else {
      this.setLabel(perpendicularProblem());
    }
  }
  //Chapter 10.1 asks to identify parallel lines in a 3d structure; skip
  
  //Chapter 10.2 requires predrawn images, find value of x
  public String xImageProblem(){
    if (xImageType == 1){
      //create image type 1 (#5 on chapter review 10.2)
      if (xOrY == 1){
        setAnswer(180 - angleA);
        this.getLabel().setIcon(image1);
        return "<html>Angle A is " + angleA + " degrees.<br>Find the value of x based on this information.</html>";
      }
      else if(xOrY == 2){
        setAnswer(angleA);
        this.getLabel().setIcon(image1);
        return "<html>Angle A is " + angleA + " degrees.<br>Find the value of y based on this information.</html>";
      }
    }
    else if (xImageType == 2){
      //create image type 2 (#6 on chapter review 10.2)
      if(xOrY == 1){
        setAnswer(180 - angleA);
        this.getLabel().setIcon(image2);
        return "Angle A is " + angleA + " degrees. Find the value of y based on this information.";
      } else if(xOrY == 2){
        setAnswer((angleA - b)/m);
        this.getLabel().setIcon(image2);
        return "Angle A is " + angleA + " degrees. Angle B is represented by the function " + generateLinFunction() + ". Find the value of x based on this information.";
      }
    }
    return "";
  }

  //Chapter 10.3 basically same as 10.2 - skip

  //Chapter 10.5 Parallel and Perpendicular lines - done

  public String generateLinFunction(){
    return "y = " + m + "x + " + b;
  }
  public String generateParallelLinFunction(){
    return "y = " + m + "x + " + (b + parallelDistance);
  }
  public String generatePerpendicularLinFunction(){
    return "y = " + perpSlope + "x + " + (perpB);    
  }
  
  public String parallelProblem(){
    setAnswer(parallelDistance);
    return "Find the distance between the parallel lines " + generateLinFunction() + " and " + generateParallelLinFunction() + ".";
    }

  public String perpendicularProblem(){
    setAnswer(perpXAnswer + perpYAnswer);
    return "Find the point at which the two perpendicular lines " + generateLinFunction() + " and " + generatePerpendicularLinFunction() + " intersect. Add the x and y values of the coordinate together and input this as the answer.";
  }
}